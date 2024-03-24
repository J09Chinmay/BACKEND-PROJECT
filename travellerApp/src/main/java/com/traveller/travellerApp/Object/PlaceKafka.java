package com.traveller.travellerApp.Object;

import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PlaceKafka extends State {
    private String searchId;
    private LocalDateTime searchTimestamp;

    public PlaceKafka() {
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
