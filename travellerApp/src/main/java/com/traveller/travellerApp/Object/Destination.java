package com.traveller.travellerApp.Object;

import javax.persistence.Entity;

import javax.persistence.Table;

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

    public Destination() {

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

// class State {
// protected String stateid;
// protected String placename;
// protected String placedetails;
// protected String placeid;
// protected String state;

// public State() {

// }

// State(String stateid, String placename, String placedetails, String placeid,
// String state) {

// this.stateid = stateid;
// this.placename = placename;
// this.placedetails = placedetails;
// this.placeid = placeid;
// this.state = state;
// }

// public String getStateid() {
// return stateid;
// }

// public void setStateId(String stateid) {
// this.stateid = stateid;
// }

// public String getPlaceName() {
// return placename;
// }

// public void setPlaceName(String placename) {
// this.placename = placename;
// }

// public String getPlacedetails() {
// return placedetails;
// }

// public void setDetails(String placedetails) {
// this.placedetails = placedetails;
// }

// public String getPlaceId() {
// return placeid;
// }

// public void setPlaceid(String placeid) {
// this.placeid = placeid;
// }

// public String getState() {
// return state;
// }

// public void setState(String state) {
// this.state = state;
// }

// }

// public class StateKafka extends State {
// private String searchId;
// private LocalDateTime searchTimestamp;

// public StateKafka() {
// super();
// }

// public String getSearchId() {
// return searchId;
// }

// public void setSearchId(String searchId) {
// this.searchId = searchId;
// }

// public LocalDateTime getSearchTimestamp() {
// return searchTimestamp;
// }

// public void setSearchTimestamp(LocalDateTime searchTimestamp) {
// this.searchTimestamp = searchTimestamp;
// }

// @Override
// public String toString() {
// ObjectMapper objectMapper = new ObjectMapper();
// try {

// ObjectNode jsonNode = objectMapper.createObjectNode();
// jsonNode.put("state", getState());
// jsonNode.put("placedetails", getPlacedetails());
// jsonNode.put("stateid", getStateid());
// jsonNode.put("placeName", getPlaceName());
// jsonNode.put("placeId", getPlaceId());
// jsonNode.put("searchId", getSearchId());
// // jsonNode.put("searchTimestamp", getSearchTimestamp().toString());

// return
// objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

// } catch (JsonProcessingException e) {
// e.printStackTrace();
// return "";
// }
// }

// }

// class Place extends State {
// // private String searchId;

// public Place() {
// super();

// }

// public String getStateid() {
// return stateid;
// }

// public void setStateId(String stateid) {
// this.stateid = stateid;
// }

// public String getPlaceName() {
// return placename;
// }

// public void setPlaceName(String placename) {
// this.placename = placename;
// }

// public String getPlacedetails() {
// return placedetails;
// }

// public void setDetails(String placedetails) {
// this.placedetails = placedetails;
// }

// public String getPlaceId() {
// return placeid;
// }

// public void setPlaceid(String placeid) {
// this.placeid = placeid;
// }

// public String getState() {
// return state;
// }

// public void setState(String state) {
// this.state = state;
// }

// // public String getSearchId() {
// // return searchId;
// // }

// // public void setSearchId(String searchId) {
// // this.searchId = searchId;
// // }

// }

// class PlaceKafka extends State {
// private String searchId;
// private LocalDateTime searchTimestamp;

// public PlaceKafka() {
// super();
// }

// public String getSearchId() {
// return searchId;
// }

// public void setSearchId(String searchId) {
// this.searchId = searchId;
// }

// public LocalDateTime getSearchTimestamp() {
// return searchTimestamp;
// }

// public void setSearchTimestamp(LocalDateTime searchTimestamp) {
// this.searchTimestamp = searchTimestamp;
// }

// @Override
// public String toString() {
// ObjectMapper objectMapper = new ObjectMapper();
// try {

// ObjectNode jsonNode = objectMapper.createObjectNode();
// jsonNode.put("state", getState());
// jsonNode.put("placedetails", getPlacedetails());
// jsonNode.put("stateid", getStateid());
// jsonNode.put("placeName", getPlaceName());
// jsonNode.put("placeId", getPlaceId());
// jsonNode.put("searchId", getSearchId());
// // jsonNode.put("searchTimestamp", getSearchTimestamp().toString());

// return
// objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

// } catch (JsonProcessingException e) {
// e.printStackTrace();
// return "";
// }
// }
// }
