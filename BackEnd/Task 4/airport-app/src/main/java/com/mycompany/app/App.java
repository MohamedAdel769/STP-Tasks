package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class App
{
    public static void main( String[] args )
    {
        List<Passenger> passengers = Arrays.asList(
           new Passenger("i123", "Mohamed", "Cairo", false, false, "Negative"),

           new Passenger("i456", "Mostafa", "Cairo", true, false, "Negative"),

           new SpecialPassenger("s111", "Oryx", "Morocco",
                            true, true, "Negative",
                            "epilepsy", Arrays.asList("Penicillin", "Aspirin")),

           new SpecialPassenger("s222", "Ela", "USA",
                            false, true, "Negative",
                            "diabetic", new ArrayList<>())
        );

        simulateAirport(passengers);
    }

    public static void simulateAirport(List<Passenger> passengers){
        passengers.forEach(passenger -> {
            displayDetails("Port Officer", passenger, (p) -> {
                System.out.println("PCR: " + p.getPcrStatus() + ", Condition: " + p.getCondition());
            });

            displayDetails("Health Officer", passenger, (p) -> {
                System.out.println("PCR: " + p.getPcrStatus() + ", Condition: " + p.getCondition() +
                        ", Last Place: " + p.getLastVisited() + ", Has Fever? " + p.isHasFever() +
                        ", Has Cough? " + p.isHasCough() + ", Allergies: " + p.getAllergies());
            });

            if(passenger.isHasFever()){
                displayDetails("PCR Conductor", passenger, (p) -> {
                    System.out.println("Has Fever? " + p.isHasFever() +
                            ", Has Cough? " + p.isHasCough());
                    p.setPcrStatus("Tested At Airport");
                });
            }

            displayDetails("Immigration Officer", passenger, (p) -> {
                System.out.println("PCR: " + p.getPcrStatus() + ", Condition: " + p.getCondition() +
                        ", Last Place: " + p.getLastVisited() + "\n");
            });
        });
    }

    private static void displayDetails(String officer, Passenger passenger, Consumer<Passenger> dataRequest){
        System.out.println(passenger.getName() + " reached " + officer);
        dataRequest.accept(passenger);
    }
}
