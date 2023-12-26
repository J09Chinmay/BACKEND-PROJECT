// package com.traveller.travellerApp;

// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.Producer;
// import org.apache.kafka.clients.producer.ProducerRecord;
// import java.util.Properties;

// public class KafkaMessageProducer {

// private final Producer<String, String> producer;
// private final String topicName;
// private final KafkaMessageConsumer kafkaConsumer = new
// KafkaMessageConsumer();

// // Assuming you have a method to consume Kafka messages in
// KafkaMessageConsumer
// // Adjust this according to your actual Kafka consumer logic
// public void consumeKafkaMessages() {
// // Call the Kafka consumer logic to receive Kafka messages
// // Assuming it has a method to receive and process Kafka messages
// String kafkaMessage = kafkaConsumer.receiveKafkaMessage(); // Method to
// receive messages from Kafka
// if (kafkaMessage != null) {
// // Process the received Kafka message
// kafkaConsumer.processMessage(kafkaMessage); // Process the received Kafka
// message
// }
// }

// public KafkaMessageProducer(String topicName) {
// this.topicName = topicName;
// this.producer = createProducer();
// }

// private Producer<String, String> createProducer() {
// Properties props = new Properties();
// props.put("bootstrap.servers", "localhost:9092");
// props.put("key.serializer",
// "org.apache.kafka.common.serialization.StringSerializer");
// props.put("value.serializer",
// "org.apache.kafka.common.serialization.StringSerializer");
// return new KafkaProducer<>(props);
// }

// public void sendMessage(String message) {
// producer.send(new ProducerRecord<>(topicName, message));
// }

// public void closeProducer() {
// producer.close();
// }
// }
package com.traveller.travellerApp;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaMessageProducer {

    private final Producer<String, String> producer;
    private final String topicName;

    public KafkaMessageProducer(String topicName) {
        this.topicName = topicName;
        this.producer = createProducer();
    }

    private Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    public void sendMessage(String message) {
        producer.send(new ProducerRecord<>(topicName, message));
    }

    public void closeProducer() {
        producer.close();
    }

}
