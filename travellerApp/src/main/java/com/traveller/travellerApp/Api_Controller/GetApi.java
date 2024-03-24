package com.traveller.travellerApp.Api_Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.travellerApp.Object.Place;
import com.traveller.travellerApp.Object.State;
import com.traveller.travellerApp.db.Db_Service;

@RestController
public class GetApi {

    @Autowired
    private Db_Service db_Service;

    public GetApi(Db_Service db_Service) {
        this.db_Service = db_Service;
    }

    @RequestMapping(value = "/api/GetState/{stateName}")
    public ArrayList<State> getPopularPlace(@PathVariable("stateName") String stateName) {
        try {
            return db_Service.stateService(stateName);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @RequestMapping(value = "/api/GetPlaceDetails/{placeName}")
    public ArrayList<Place> getPlaceDetailsByName(@PathVariable("placeName") String placeName) {
        try {
            return db_Service.placeService(placeName);
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