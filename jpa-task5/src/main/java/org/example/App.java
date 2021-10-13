package org.example;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

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
