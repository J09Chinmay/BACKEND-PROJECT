package com.traveller.travellerApp.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traveller.travellerApp.Values.Kafkaconfig;

import java.util.Properties;

@Component
public class KafkaMessageProducer {
    private static final Logger log = LoggerFactory.getLogger(KafkaMessageProducer.class);

    private final Producer<String, String> producer;
    private final String topicName1;
    private final String topicName2;

    @Autowired
    public KafkaMessageProducer(Kafkaconfig kafkaConfig) {
        this.topicName1 = kafkaConfig.getTopicName1();
        this.topicName2 = kafkaConfig.getTopicName2();
        this.producer = createProducer(kafkaConfig);
    }

    private Producer<String, String> createProducer(Kafkaconfig kafkaConfig) {
        try {
            log.info("Kafka producer started...");
            Properties props = new Properties();
            props.put("bootstrap.servers", kafkaConfig.getBootstrapServers());
            props.put("key.serializer", kafkaConfig.getKeySerializer());
            props.put("value.serializer", kafkaConfig.getValueSerializer());
            return new KafkaProducer<>(props);
        } catch (Exception e) {
            log.error("Error creating Kafka producer: " + e.getMessage());
            return null;
        }
    }

    public void sendMessageToTopic1(String message) {
        sendMessage(topicName1, message);
    }

    public void sendMessageToTopic2(String message) {
        sendMessage(topicName2, message);
    }

    private void sendMessage(String topicName, String message) {
        try {
            log.info("Producing Kafka message to topic '{}': {}", topicName, message);
            producer.send(new ProducerRecord<>(topicName, message));
        } catch (Exception e) {
            log.error("Error producing Kafka message: " + e.getMessage());
        }
    }

    public void closeProducer() {
        try {
            log.info("Closing Kafka producer...");
            producer.close();
        } catch (Exception e) {
            log.error("Error closing Kafka producer: " + e.getMessage());
        }
    }
}
