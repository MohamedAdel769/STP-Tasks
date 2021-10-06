package com.mycompany.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App
{
    public static void main( String[] args )
    {
        List<Passenger> passengers = Arrays.asList(
           new Passenger("i123", "Mohamed", "Cairo", false, false, "Negative"),
           new Passenger("i456", "Mostafa", "Cairo", true, false, "Negative"),
           new Passenger("i789", "Lesion", "Cairo", false, false, "Negative")
        );

        passengers.forEach(passenger -> {
            // port office
            System.out.println(passenger.getName() + " reached Port Officer");
            Details PortRequest = () -> {
                System.out.println("PCR: " + passenger.getPcrStatus() + ", No Conditions");
            };
            passenger.requestDetails(PortRequest);

            System.out.println(passenger.getName() + " reached Health Officer");
            Details HealthRequest = () -> {
                System.out.println("PCR: " + passenger.getPcrStatus() + ", No Conditions" +
                        ", Last Place: " + passenger.getLastVisited() + ", Has Fever? " + passenger.isHasFever() +
                        ", Has Cough? " + passenger.isHasCough() + ", No Allergies");
            };
            passenger.requestDetails(HealthRequest);

            if(passenger.isHasFever()){
                System.out.println(passenger.getName() + " reached PCR Conductor");
                System.out.println("Has Fever? " + passenger.isHasFever() +
                        ", Has Cough? " + passenger.isHasCough());

                passenger.setPcrStatus("Tested At Airport");
            }

            System.out.println(passenger.getName() + " reached Immigration Officer");

            System.out.println("PCR: " + passenger.getPcrStatus() + ", No Conditions" +
                    ", Last Place: " + passenger.getLastVisited() + "\n");
        });
    }
}
