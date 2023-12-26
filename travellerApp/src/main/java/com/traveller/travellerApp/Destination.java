package com.traveller.travellerApp;

import java.time.LocalDateTime;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Table;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

@Entity
@Data
@Table(name = "india")
public class Destination {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String state;
    private String famousfor;
    private String searchId;

    Destination() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFamousFor() {
        return famousfor;
    }

    public void setFamousFor(String famousfor) {

        this.famousfor = famousfor;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

}

class State {
    protected String stateid;
    protected String placename;
    protected String placedetails;
    protected String placeid;
    protected String state;

    State() {

    }

    // State(String stateid, String placename, String placedetails, String placeid,
    // String state, String searchId) {

    // this.stateid = stateid;
    // this.placename = placename;
    // this.placedetails = placedetails;
    // this.placeid = placeid;
    // this.state = state;
    // this.searchId = searchId;
    // }

    State(String stateid, String placename, String placedetails, String placeid, String state) {

        this.stateid = stateid;
        this.placename = placename;
        this.placedetails = placedetails;
        this.placeid = placeid;
        this.state = state;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateId(String stateid) {
        this.stateid = stateid;
    }

    public String getPlaceName() {
        return placename;
    }

    public void setPlaceName(String placename) {
        this.placename = placename;
    }

    public String getPlacedetails() {
        return placedetails;
    }

    public void setDetails(String placedetails) {
        this.placedetails = placedetails;
    }

    public String getPlaceId() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

class StateKafka extends State {
    private String searchId;
    private LocalDateTime searchTimestamp;

    StateKafka() {
        super();
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public LocalDateTime getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(LocalDateTime searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }

    @Override
    public String toString() {
        // return "{" +
        // "stateId='" + stateid + '\'' +
        // ", placeDetails='" + placedetails + '\'' +
        // ", state='" + state + '\'' +
        // ", searchId='" + searchId + '\'' +
        // ", placeId='" + placeid + '\'' +
        // ", placeName='" + placename + '\'' +
        // ", searchTimestamp='" + searchTimestamp + '\'' +
        // '}';
        return "**********************************************\n"
                + searchTimestamp + "\n {" +
                "stateId='" + stateid + '\'' + ",\n" +
                " placeDetails='" + placedetails + '\'' + ",\n" +
                " state='" + state + '\'' + ",\n" +
                " searchId='" + searchId + '\'' + ",\n" +
                " placeId='" + placeid + '\'' + ",\n" +
                " placeName='" + placename + '\'' +
                '}' + "\n" +
                "**********************************************\n";
    }
}

class Place extends State {
    private String searchId;
    // private LocalDateTime searchTimestamp;

    Place() {
        super();

    }

    public String getStateid() {
        return stateid;
    }

    public void setStateId(String stateid) {
        this.stateid = stateid;
    }

    public String getPlaceName() {
        return placename;
    }

    public void setPlaceName(String placename) {
        this.placename = placename;
    }

    public String getPlacedetails() {
        return placedetails;
    }

    public void setDetails(String placedetails) {
        this.placedetails = placedetails;
    }

    public String getPlaceId() {
        return placeid;
    }

    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    // public LocalDateTime getSearchTimestamp() {
    // return searchTimestamp;
    // }

    // public void setSearchTimestamp(LocalDateTime searchTimestamp) {
    // this.searchTimestamp = searchTimestamp;
    // }

}

class PlaceKafka extends State {
    private String searchId;
    private LocalDateTime searchTimestamp;

    PlaceKafka() {
        super();
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public LocalDateTime getSearchTimestamp() {
        return searchTimestamp;
    }

    public void setSearchTimestamp(LocalDateTime searchTimestamp) {
        this.searchTimestamp = searchTimestamp;
    }

    @Override
    public String toString() {
        return "**********************************************\n"
                + searchTimestamp + "\n {" +
                "stateId='" + stateid + '\'' + ",\n" +
                " placeDetails='" + placedetails + '\'' + ",\n" +
                " state='" + state + '\'' + ",\n" +
                " searchId='" + searchId + '\'' + ",\n" +
                " placeId='" + placeid + '\'' + ",\n" +
                " placeName='" + placename + '\'' +
                '}' + "\n" +
                "**********************************************\n";
    }
}
