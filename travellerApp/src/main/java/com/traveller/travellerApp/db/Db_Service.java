package com.traveller.travellerApp.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traveller.travellerApp.TravellerAppApplication;
import com.traveller.travellerApp.Object.Place;
import com.traveller.travellerApp.Object.State;

@Component
public class Db_Service {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Db_Service.class);
    @Autowired
    private TravellerAppApplication travellerAppApplication;
    @Autowired
    private Place_db place_db;
    @Autowired
    private Psql_Query psql_Query;

    public Db_Service(TravellerAppApplication travellerAppApplication, Place_db place_db, Psql_Query psql_Query) {
        this.travellerAppApplication = travellerAppApplication;
        this.place_db = place_db;
        this.psql_Query = psql_Query;
    }

    public ArrayList<State> stateService(String stateName) {
        ArrayList<State> list2 = new ArrayList<>();

        try (Connection conn = travellerAppApplication.connection;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(psql_Query.StateQuery(stateName))) {
            place_db.display2(rs, list2, UUID.randomUUID().toString());
            return list2;
        } catch (SQLException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }

    public ArrayList<Place> placeService(String placeName) {
        ArrayList<Place> list3 = new ArrayList<>();

        try (Connection conn = travellerAppApplication.connection;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(psql_Query.PlaceQuery(placeName))) {
            place_db.display3(rs, list3, UUID.randomUUID().toString());

            return list3;
        } catch (SQLException ex) {
            log.info(ex.getMessage());
            return null;
        }
    }
}
