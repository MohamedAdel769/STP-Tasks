package com.mycompany.app;

interface Details{
    void showDetails();
}

public class Passenger {

    private String id;
    private String name;
    private String lastVisited;
    private boolean hasFever;
    private boolean hasCough;
    private String pcrStatus;

    Passenger(String id, String name, String lastVisited, boolean hasFever, boolean hasCough, String status){
        this.id = id;
        this.name = name;
        this.lastVisited = lastVisited;
        this.hasCough = hasCough;
        this.hasFever = hasFever;
        this.pcrStatus = status;
    }

    public void requestDetails(Details detailsRequest){
        detailsRequest.showDetails();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(String lastVisited) {
        this.lastVisited = lastVisited;
    }

    public boolean isHasFever() {
        return hasFever;
    }

    public void setHasFever(boolean hasFever) {
        this.hasFever = hasFever;
    }

    public boolean isHasCough() {
        return hasCough;
    }

    public void setHasCough(boolean hasCough) {
        this.hasCough = hasCough;
    }

    public String getPcrStatus() {
        return pcrStatus;
    }

    public void setPcrStatus(String pcrStatus) {
        this.pcrStatus = pcrStatus;
    }
}

class SpecialPassenger extends Passenger{
    //TODO: improve data types
    private String condition;
    private String allergy;

    SpecialPassenger(String id, String name, String lastVisited, boolean hasFever, boolean hasCough, String status,
                     String condition, String allergy) {
        super(id, name, lastVisited, hasFever, hasCough, status);
        this.condition = condition;
        this.allergy = allergy;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }
}
