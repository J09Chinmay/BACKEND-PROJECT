package com.traveller.travellerApp.kafka;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traveller.travellerApp.Object.PlaceKafka;
import com.traveller.travellerApp.Object.StateKafka;

import jakarta.annotation.PreDestroy;

@Component
public class SearchData {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(SearchData.class);

    // private final KafkaMessageProducer kafkaProducer = new
    // KafkaMessageProducer("xyz");
    // private final KafkaMessageProducer kafkaProducer2 = new
    // KafkaMessageProducer("abc");
    private final KafkaMessageProducer kafkaProducer;

    @Autowired
    public SearchData(KafkaMessageProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void stateSearchData(ResultSet rs, String uuid) throws SQLException {
        StateKafka state2 = new StateKafka();
        state2.setSearchId(uuid);
        state2.setState(rs.getString("state"));
        state2.setStateId(rs.getString("stateid"));
        state2.setPlaceName(rs.getString("placename"));
        state2.setPlaceid(rs.getString("placeid"));
        state2.setDetails(rs.getString("placedetails"));
        kafkaProducer.sendMessageToTopic1(state2.toString());
    }

    public void placeSearchData(ResultSet rs, String uuid) throws SQLException {
        PlaceKafka place2 = new PlaceKafka();
        place2.setSearchId(uuid);
        place2.setState(rs.getString("state"));
        place2.setStateId(rs.getString("stateid"));
        place2.setPlaceName(rs.getString("placename"));
        place2.setPlaceid(rs.getString("placeid"));
        place2.setDetails(rs.getString("placedetails"));
        kafkaProducer.sendMessageToTopic2(place2.toString());
    }

    @PreDestroy
    public void closeProducer() {
        try {
            kafkaProducer.closeProducer();
            log.info("Kafka closed producer ............");
            // kafkaProducer2.closeProducer();
            // log.info("Kafka closed producer 2............");

        } catch (Exception e) {
            log.error("Errorrr==" + e);
        }
    }
}
