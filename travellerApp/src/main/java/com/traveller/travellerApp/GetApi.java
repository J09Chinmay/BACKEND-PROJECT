package com.traveller.travellerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PreDestroy;

@RestController
public class GetApi {
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "chinmay09";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private final KafkaMessageProducer kafkaProducer = new KafkaMessageProducer("searchData");
    // private final DataSaverr dataSaver;

    // public GetApi(DataSaverr dataSaver) {
    // this.dataSaver = dataSaver;
    // }

    // private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @RequestMapping(value = "/api/state")
    public ArrayList<Destination> getState() {

        ArrayList<Destination> list = new ArrayList<>();

        String SQL;

        SQL = "SELECT * FROM india";
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            display(rs, list, UUID.randomUUID().toString());
            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public void display(ResultSet rs, ArrayList<Destination> list, String uuid)
            throws SQLException {
        while (rs.next()) {
            Destination destination = new Destination();

            destination.setId(rs.getString("id"));
            destination.setState(rs.getString("state"));
            destination.setFamousFor(rs.getString("famousfor"));
            destination.setSearchId(uuid);
            list.add(destination);
        }
    }

    @RequestMapping(value = "/api/GetState/{stateName}")
    public ArrayList<State> getPopularPlace(@PathVariable("stateName") String stateName) {
        ArrayList<State> list2 = new ArrayList<>();
        String SQL = "SELECT p.placeid, p.stateid, p.placename, p.placedetails, i.state " +
                "FROM place p " +
                "INNER JOIN india i ON p.stateid = i.id " +
                "WHERE i.state = '" + stateName + "'";
        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            display2(rs, list2, UUID.randomUUID().toString());
            String jsonString = new Gson().toJson(list2);

            kafkaTemplate.send("searchData", jsonString);

            return list2;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public void display2(ResultSet rs, ArrayList<State> list2, String uuid) throws SQLException {
        while (rs.next()) {
            State state = new State();

            state.setState(rs.getString("state"));
            state.setStateId(rs.getString("stateid"));
            state.setPlaceName(rs.getString("placename"));
            state.setPlaceid(rs.getString("placeid"));
            state.setDetails(rs.getString("placedetails"));
            list2.add(state);
            StateKafka state2 = new StateKafka();
            state2.setSearchTimestamp(LocalDateTime.now());
            state2.setSearchId(uuid);
            state2.setState(rs.getString("state"));
            state2.setStateId(rs.getString("stateid"));
            state2.setPlaceName(rs.getString("placename"));
            state2.setPlaceid(rs.getString("placeid"));
            state2.setDetails(rs.getString("placedetails"));
            kafkaProducer.sendMessage(state2.toString());
            // executor.submit(() -> {
            // for (State s : list2) {
            // dataSaver.saveStateToDatabase(s, UUID.fromString(uuid));
            // }
            // });
        }

    }

    @RequestMapping(value = "/api/GetPlaceDetails/{placeName}")
    public ArrayList<Place> getPlaceDetailsByName(@PathVariable("placeName") String placeName) {
        ArrayList<Place> list3 = new ArrayList<>();
        String SQL = "SELECT p.placeid, p.stateid, p.placename, p.placedetails," +
                "i.state " +
                "FROM place p " +
                "INNER JOIN india i ON p.stateid = i.id " +
                "WHERE p.placename = '" + placeName + "'";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL)) {
            display3(rs, list3, UUID.randomUUID().toString());
            String jsonString = new Gson().toJson2(list3);

            kafkaTemplate.send("searchData", jsonString);

            return list3;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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
            PlaceKafka place2 = new PlaceKafka();
            place2.setSearchId(uuid);
            place2.setState(rs.getString("state"));
            place2.setStateId(rs.getString("stateid"));
            place2.setPlaceName(rs.getString("placename"));
            place2.setPlaceid(rs.getString("placeid"));
            place2.setDetails(rs.getString("placedetails"));
            place2.setSearchTimestamp(LocalDateTime.now());
            kafkaProducer.sendMessage(place2.toString());
            // executor.submit(() -> {
            // for (Place pstate : list3) {
            // dataSaver.savePlaceToDatabase(pstate, UUID.fromString(uuid));
            // }
            // });
        }

    }

    @PreDestroy
    public void closeProducer() {
        kafkaProducer.closeProducer();
    }

    // @PreDestroy
    // public void shutdownExecutor() {
    // executor.shutdown();
    // }

}
