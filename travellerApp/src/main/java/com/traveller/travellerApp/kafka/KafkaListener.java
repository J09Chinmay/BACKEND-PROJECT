package com.traveller.travellerApp.kafka;

public @interface KafkaListener {

    String topics();

    String groupId();

}
