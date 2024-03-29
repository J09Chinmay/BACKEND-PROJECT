package com.traveller.travellerApp.Api_Controller;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.traveller.travellerApp.TravellerAppApplication;
import com.traveller.travellerApp.Object.Place;
import com.traveller.travellerApp.Object.State;
import com.traveller.travellerApp.Values.Database_config;
import com.traveller.travellerApp.db.Db_Service;

@RestController
public class GetApi {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(GetApi.class);

    @Autowired
    private Db_Service db_Service;
    private TravellerAppApplication travellerAppApplication;
    // @Autowired
    // private Database_config appConfig;

    public GetApi(Db_Service db_Service, TravellerAppApplication travellerAppApplication) {
        // , Database_config appConfig) {
        this.travellerAppApplication = travellerAppApplication;
        this.db_Service = db_Service;
        // this.appConfig = appConfig;
    }

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

    @RequestMapping(value = "/api/GetState/{stateName}")
    public ArrayList<State> getPopularPlace(@PathVariable("stateName") String stateName) {
        try {
            log.info("Respond ok!!");
            return db_Service.stateService(stateName, travellerAppApplication.connect());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @RequestMapping(value = "/api/GetPlaceDetails/{placeName}")
    public ArrayList<Place> getPlaceDetailsByName(@PathVariable("placeName") String placeName) {
        try {
            log.info("Respond ok!!");
            return db_Service.placeService(placeName, travellerAppApplication.connect());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}

// @RequestMapping(value = "/api/state")
// public ArrayList<Destination> getState() {

// ArrayList<Destination> list = new ArrayList<>();

// String SQL;

// SQL = "SELECT * FROM india";
// try (Connection conn = travellerAppApplication.connection;
// Statement stmt = conn.createStatement();
// ResultSet rs = stmt.executeQuery(SQL)) {
// display(rs, list, UUID.randomUUID().toString());
// return list;
// } catch (SQLException ex) {
// System.out.println(ex.getMessage());
// }

// return null;
// }
// public void display(ResultSet rs, ArrayList<Destination> list, String uuid)
// throws SQLException {
// while (rs.next()) {
// Destination destination = new Destination();

// destination.setId(rs.getString("id"));
// destination.setState(rs.getString("state"));
// destination.setFamousFor(rs.getString("famousfor"));
// destination.setSearchId(uuid);
// list.add(destination);
// }
// }