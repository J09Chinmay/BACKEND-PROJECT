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

import com.traveller.travellerApp.Object.Place;
import com.traveller.travellerApp.Object.State;
// import com.traveller.travellerApp.Values.Database_config;

@Component
public class Db_Service {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Db_Service.class);
    @Autowired
    private Place_db place_db;
    @Autowired
    private Psql_Query psql_Query;

    public Db_Service(Place_db place_db,
            Psql_Query psql_Query) {

        this.place_db = place_db;
        this.psql_Query = psql_Query;

    }

    public ArrayList<State> stateService(String stateName, Connection connection) {
        ArrayList<State> list2 = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(psql_Query.StateQuery(stateName))) {
            place_db.display2(rs, list2, UUID.randomUUID().toString());
            return list2;
        } catch (SQLException ex) {
            log.info("from DB_Service====" + ex.getMessage());
            return null;
        }
    }

    public ArrayList<Place> placeService(String placeName, Connection connection) {
        ArrayList<Place> list3 = new ArrayList<>();

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(psql_Query.PlaceQuery(placeName))) {

            place_db.display3(rs, list3, UUID.randomUUID().toString());

            return list3;
        } catch (SQLException ex) {
            log.info(ex.getMessage());
            log.info("from DB_Service====" + ex.getMessage());
            return null;
        }
    }
}

// public Connection connection;
// public Connection connection;

// @Autowired
// public Connection connect() {
// try {
// String url = appConfig.getDatasourceUrl();
// String user = appConfig.getDatasourceUsername();
// String password = appConfig.getDatasourcePassword();

// log.info("Connected to PostgreSQL database Done.............");
// return connection = DriverManager.getConnection(url, user, password);
// } catch (SQLException e) {
// log.error("Failed to connect to PostgreSQL database: " + e.getMessage());
// }
// return null;
// }