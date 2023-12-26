package com.traveller.travellerApp;

public @interface KafkaListener {

    String topics();

    String groupId();

}
