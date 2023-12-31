package com.traveller.travellerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class DataSaverr {

    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "chinmay09";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void saveStateToDatabase(State obj, UUID uuid) {
        String SQL = "INSERT INTO datastore (uuid, state, stateid, placename, placeid, placedetails, time) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setObject(1, uuid);
            pstmt.setString(2, obj.getState());
            pstmt.setString(3, obj.getStateid());
            pstmt.setString(4, obj.getPlaceName());
            pstmt.setString(5, obj.getPlaceId());
            pstmt.setString(6, obj.getPlacedetails());
            pstmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void savePlaceToDatabase(Place place, UUID uuid) {
        String SQL = "INSERT INTO datastore (uuid, state, stateid, placename,placeid, placedetails, time) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setObject(1, uuid); // Use provided UUID
            pstmt.setString(2, place.getState());
            pstmt.setString(3, place.getStateid());
            pstmt.setString(4, place.getPlaceName());
            pstmt.setString(5, place.getPlaceId());
            pstmt.setString(6, place.getPlacedetails());
            pstmt.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
