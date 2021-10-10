package com.sumerge.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("SE", "SAM", "XXXXXX"));
        employees.add(new Employee("SE", "Nancy", "YYYYY"));
        employees.add(new Employee("ASE", "Mark", "ZZZZZ"));

        filter(employees);
    }

    public static void filter(List<Employee> employees) {
        Map<String, List<Employee>> groups = employees.stream().collect(groupingBy(Employee::getTitle));

        groups.entrySet().stream()
                .map(entry -> {
                    int count = entry.getValue().size();
                    String titleOutput = count < 2 ? "*Special Title* " : "Title: ";
                    System.out.println(titleOutput + entry.getKey() + " Count: " + count);
                    return entry.getValue();
                }).forEach(group -> {
                    group.forEach(System.out::println);
                });
    }
}
