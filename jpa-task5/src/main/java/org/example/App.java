package org.example;

import entities.Employee;
import entities.Role;
import org.example.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> employees;

        System.out.println("a.Query to display all employees with their respective role and information");
        employees = employeeRepository.selectAll();
        employees.forEach(System.out::println);

        System.out.println("\n\nb.Query to display all employees within a specific project (referenced by project name)\n");
        employees = employeeRepository.getEmployeesByProject("ABC");
        employees.forEach(System.out::println);

        // add new employee
        /*Employee newEmp = new Employee(100, "new Employee", "new@gmail.com",
                "1234567899", (short) 22, "12345678911234", new Role(101, "associate",
                "SE", new ArrayList<>()));
        employeeRepository.insertEmployee(newEmp);

        System.out.println("\n\nc.Query to add an employee to a certain project\n");
        employeeRepository.addEmployeetoProject(newEmp, "Dashmala");*/

        employeeRepository.close();
    }
}
