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
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("SE", "SAM", "XXXXXX"));
        employees1.add(new Employee("SE", "Nancy", "YYYYY"));
        employees1.add(new Employee("ASE", "Mark", "ZZZZZ"));

        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee("SE", "dola", "xxx"));
        employees2.add(new Employee("PM", "test", "xxx"));
        employees2.add(new Employee("SE", "adel", "xxx"));
        employees2.add(new Employee("PM", "ahmed", "xxx"));
        employees2.add(new Employee("SE", "mohamed", "xxx"));

        //filter(employees1);
        filter(employees2);
    }

    public static void filter(List<Employee> employees) {
        Map<String, Integer> titleCount = new HashMap<>();
        Map<String, List<Employee>> groups = new HashMap<>();

        for(Employee employee: employees){
            String title = employee.getTitle();

            if(titleCount.containsKey(title)) {
                int oldCount = titleCount.get(title);
                titleCount.put(title, oldCount+1);

                List<Employee> oldGroup = groups.get(title);
                oldGroup.add(employee);
                groups.put(title, oldGroup);
            }
            else {
                titleCount.put(title, 1);

                List<Employee> newGroup = new ArrayList<>();
                newGroup.add(employee);
                groups.put(title, newGroup);
            }
        }

        for (String title : groups.keySet()) {
            System.out.println("Title: " + title + " Count: " + titleCount.get(title));
            for(Employee employee: groups.get(title)){
                System.out.println("Name: " + employee.getName() + " - Mobile: " + employee.getMobile());
            }
        }
    }
}
