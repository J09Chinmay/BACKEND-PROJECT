package com.traveller.travellerApp.Object;

public class Place extends State {
    // private String searchId;

    public Place() {
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

    // public String getSearchId() {
    // return searchId;
    // }

    // public void setSearchId(String searchId) {
    // this.searchId = searchId;
    // }

}