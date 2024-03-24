package com.traveller.travellerApp.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.traveller.travellerApp.Object.Place;
// import com.traveller.travellerApp.Object.PlaceKafka;
import com.traveller.travellerApp.Object.State;
// import com.traveller.travellerApp.Object.StateKafka;
// import com.traveller.travellerApp.kafka.KafkaMessageProducer;

// import jakarta.annotation.PreDestroy;
@Component
public class Place_db {
    // private final KafkaMessageProducer kafkaProducer = new
    // KafkaMessageProducer("xyz");
    // private final KafkaMessageProducer kafkaProducer2 = new
    // KafkaMessageProducer("abc");

    public void display2(ResultSet rs, ArrayList<State> list2, String uuid) throws SQLException {
        while (rs.next()) {
            State state = new State();

            state.setState(rs.getString("state"));
            state.setStateId(rs.getString("stateid"));
            state.setPlaceName(rs.getString("placename"));
            state.setPlaceid(rs.getString("placeid"));
            state.setDetails(rs.getString("placedetails"));
            list2.add(state);
            // StateKafka state2 = new StateKafka();
            // // state2.setSearchTimestamp(LocalDateTime.now());
            // state2.setSearchId(uuid);
            // state2.setState(rs.getString("state"));
            // state2.setStateId(rs.getString("stateid"));
            // state2.setPlaceName(rs.getString("placename"));
            // state2.setPlaceid(rs.getString("placeid"));
            // state2.setDetails(rs.getString("placedetails"));
            // kafkaProducer.sendMessage(state2.toString());

        }

    }

    public void display3(ResultSet rs, ArrayList<Place> list3, String uuid) throws SQLException {
        while (rs.next()) {
            Place place = new Place();
            place.setState(rs.getString("state"));
            place.setStateId(rs.getString("stateid"));
            place.setPlaceName(rs.getString("placename"));
            place.setPlaceid(rs.getString("placeid"));
            place.setDetails(rs.getString("placedetails"));
            list3.add(place);
            // PlaceKafka place2 = new PlaceKafka();
            // place2.setSearchId(uuid);
            // place2.setState(rs.getString("state"));
            // place2.setStateId(rs.getString("stateid"));
            // place2.setPlaceName(rs.getString("placename"));
            // place2.setPlaceid(rs.getString("placeid"));
            // place2.setDetails(rs.getString("placedetails"));
            // // place2.setSearchTimestamp(LocalDateTime.now());
            // kafkaProducer2.sendMessage(place2.toString());

        }

    }

    // @PreDestroy
    // public void closeProducer() {
    // kafkaProducer.closeProducer();
    // kafkaProducer2.closeProducer();
    // }
}
