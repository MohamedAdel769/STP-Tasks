package com.mycompany.app;

import java.util.List;

public class SpecialPassenger extends Passenger{
    private String condition;
    private List<String> allergies;

    SpecialPassenger(String id,
                     String name,
                     String lastVisited,
                     boolean hasFever,
                     boolean hasCough,
                     String status,
                     String condition,
                     List<String> allergies)
    {
        super(id, name, lastVisited, hasFever, hasCough, status);
        this.condition = condition;
        this.allergies = allergies;
    }

    public String getCondition() {
        if(condition == null || condition.length() == 0)
            return super.getCondition();
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<String> getAllergies() {
        if(allergies.size() == 0)
            return super.getAllergies();
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }
}
