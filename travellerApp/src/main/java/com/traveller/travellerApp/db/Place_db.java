package com.traveller.travellerApp.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traveller.travellerApp.Object.Place;
import com.traveller.travellerApp.Object.State;

import com.traveller.travellerApp.kafka.SearchData;

@Component
public class Place_db {

    @Autowired
    private SearchData searchData;

    public void display2(ResultSet rs, ArrayList<State> list2, String uuid) throws SQLException {
        while (rs.next()) {
            State state = new State();
            state.setState(rs.getString("state"));
            state.setStateId(rs.getString("stateid"));
            state.setPlaceName(rs.getString("placename"));
            state.setPlaceid(rs.getString("placeid"));
            state.setDetails(rs.getString("placedetails"));
            list2.add(state);
            searchData.stateSearchData(rs, uuid);
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
            searchData.placeSearchData(rs, uuid);
        }

    }

}
