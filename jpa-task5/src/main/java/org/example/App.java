package org.example;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.entities.Role;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.ProjectRepository;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
@ApplicationPath("/api")
public class App extends Application
{
    public static void main( String[] args )
    {
        /*ProjectRepository projectRepository = new ProjectRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Project project = projectRepository.getProjectByName("ABC");

        project.getEmployees().forEach(System.out::println);
        employeeRepository.selectAll().forEach(System.out::println);*/
    }
}
