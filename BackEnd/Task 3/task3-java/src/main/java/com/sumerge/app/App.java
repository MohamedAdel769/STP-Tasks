package com.sumerge.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("SE", "SAM", "XXXXXX"));
        employees.add(new Employee("SE", "Nancy", "YYYYY"));
        employees.add(new Employee("ASE", "Mark", "ZZZZZ"));

        filter(employees);
    }

    public static void filter(List<Employee> employees) {
        Map<String, List<Employee>> groups = new HashMap<>();

        employees.forEach(employee -> {
            String title = employee.getTitle();

            if(groups.containsKey(title)){
                groups.get(title).add(employee);
            }
            else {
                List<Employee> newGroup = new ArrayList<>();
                newGroup.add(employee);
                groups.put(title, newGroup);
            }
        });

        for (String title : groups.keySet()) {
            int count = groups.get(title).size();
            String titleOutput = count < 2 ? "*Special Title* " : "Title: ";
            System.out.println(titleOutput + title + " Count: " + count);

            for(Employee employee: groups.get(title)){
                System.out.println("Name: " + employee.getName() + " - Mobile: " + employee.getMobile());
            }

            System.out.println();
        }
    }
}
