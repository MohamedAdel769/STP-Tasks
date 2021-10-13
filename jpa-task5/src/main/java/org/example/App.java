package org.example;

import org.example.entities.Employee;
import org.example.entities.Role;
import org.example.repositories.EmployeeRepository;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
@ApplicationPath("app")
public class App
{
    public static void main( String[] args )
    {
//        EmployeeRepository employeeRepository = new EmployeeRepository();
//        List<Employee> employees;
//
//        System.out.println("a.Query to display all employees with their respective role and information");
//        employees = employeeRepository.selectAll();
//        employees.forEach(System.out::println);
//
//        System.out.println("\n\nb.Query to display all employees within a specific project (referenced by project name)\n");
//        Set<Employee> projectEmployees = employeeRepository.getEmployeesByProject("ABC");
//        projectEmployees.forEach(System.out::println);
//
//        // add new employee
//        /*Employee newEmp = new Employee(4004, "Layla", "layla@gmail.com",
//                "1234569999", (short) 32, "12345688222222", employeeRepository.getRole(404));
//        employeeRepository.insertEmployee(newEmp);*/
//
//        System.out.println("\n\nc.Query to add an employee to a certain project\n");
//        employeeRepository.addEmployeetoProject(employeeRepository.getEmployee(100), "ABC");
//
//        // Make sure that the employee added successfully.
//        projectEmployees = employeeRepository.getEmployeesByProject("ABC");
//        projectEmployees.forEach(System.out::println);
//
//
//        System.out.println("\n\nBonus. Create a query that displays employees with a certain role who are currently not working on a project\n");
//        Role role = employeeRepository.getRole(404);
//        List<Employee> idleEmployees = employeeRepository.getIdleEmployees(role);
//        idleEmployees.forEach(System.out::println);
//
//        employeeRepository.close();
    }
}
