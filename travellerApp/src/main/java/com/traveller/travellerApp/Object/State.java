package com.traveller.travellerApp.Object;

public class State {
    protected String stateid;
    protected String placename;
    protected String placedetails;
    protected String placeid;
    protected String state;

    public State() {

    }

    public State(String stateid, String placename, String placedetails, String placeid, String state) {

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