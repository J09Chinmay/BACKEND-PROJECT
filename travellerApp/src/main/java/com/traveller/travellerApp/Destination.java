package com.traveller.travellerApp;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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

    // @Override
    // public String toString() {

    // return "\n"
    // + "time=" + searchTimestamp + "\n" +
    // "stateId='" + stateid + '\'' + "\n" +
    // " placeDetails='" + placedetails + '\'' + "\n" +
    // " state='" + state + '\'' + "\n" +
    // " searchId='" + searchId + '\'' + "\n" +
    // " placeId='" + placeid + '\'' + "\n" +
    // " placeName='" + placename + '\'' +
    // "\n";
    // }
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // return objectMapper.writeValueAsString(
            // this.getState() + " " + this.getPlacedetails() + " " + this.getStateid() + "
            // " + this.getPlaceName()
            // + " " + this.getPlaceId() + this.getSearchId() + " " +
            // this.getSearchTimestamp());
            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("state", getState());
            jsonNode.put("placedetails", getPlacedetails());
            jsonNode.put("stateid", getStateid());
            jsonNode.put("placeName", getPlaceName());
            jsonNode.put("placeId", getPlaceId());
            jsonNode.put("searchId", getSearchId());
            // jsonNode.put("searchTimestamp", getSearchTimestamp().toString());

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
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
        // return "\n"
        // + "time=" + searchTimestamp + "\n {" +
        // "stateId='" + stateid + '\'' + ",\n" +
        // " placeDetails='" + placedetails + '\'' + ",\n" +
        // " state='" + state + '\'' + ",\n" +
        // " searchId='" + searchId + '\'' + ",\n" +
        // " placeId='" + placeid + '\'' + ",\n" +
        // " placeName='" + placename + '\'' +
        // '}' + "\n";
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            ObjectNode jsonNode = objectMapper.createObjectNode();
            jsonNode.put("state", getState());
            jsonNode.put("placedetails", getPlacedetails());
            jsonNode.put("stateid", getStateid());
            jsonNode.put("placeName", getPlaceName());
            jsonNode.put("placeId", getPlaceId());
            jsonNode.put("searchId", getSearchId());
            // jsonNode.put("searchTimestamp", getSearchTimestamp().toString());

            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
