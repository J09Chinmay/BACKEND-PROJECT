package com.traveller.travellerApp.db;

import org.springframework.stereotype.Component;

@Component
public class Psql_Query {

    public String StateQuery(String stateName) {
        String SQL;
        SQL = "SELECT p.placeid, p.stateid, p.placename, p.placedetails, i.state " +
                "FROM place p " +
                "INNER JOIN india i ON p.stateid = i.id " +
                "WHERE i.state = '" + stateName + "'";
        return SQL;
    }

    public String PlaceQuery(String placeName) {
        String SQL = "SELECT p.placeid, p.stateid, p.placename, p.placedetails," +
                "i.state " +
                "FROM place p " +
                "INNER JOIN india i ON p.stateid = i.id " +
                "WHERE p.placename = '" + placeName + "'";
        return SQL;
    }
}
