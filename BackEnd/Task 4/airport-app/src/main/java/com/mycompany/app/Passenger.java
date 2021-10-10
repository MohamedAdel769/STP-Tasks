package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Passenger {
    private String id;
    private String name;
    private String lastVisited;
    private boolean hasFever;
    private boolean hasCough;
    private String pcrStatus;

    Passenger(String id,
              String name,
              String lastVisited,
              boolean hasFever,
              boolean hasCough,
              String status)
    {
        this.id = id;
        this.name = name;
        this.lastVisited = lastVisited;
        this.hasCough = hasCough;
        this.hasFever = hasFever;
        this.pcrStatus = status;
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

    public String getCondition() {
        return "No conditions";
    }

    public List<String> getAllergies() {
        return Collections.singletonList("No allergies");
    }
}


