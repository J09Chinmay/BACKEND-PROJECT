package com.traveller.travellerApp.Values;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-config.properties")
public class Kafkaconfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;
    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;
    @Value("${kafka.topic-name1}")
    private String topicName1;
    @Value("${kafka.topic-name2}")
    private String topicName2;

    public String getTopicName1() {
        return topicName1;
    }

    public String getTopicName2() {
        return topicName2;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }
}
