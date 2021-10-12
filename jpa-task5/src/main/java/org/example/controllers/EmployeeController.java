package org.example.controllers;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.ProjectRepository;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeController(){
        employeeRepository = new EmployeeRepository();
        projectRepository = new ProjectRepository();
    }

    @GET
    public String testAPI(){
        return "Hello JAX-RS";
    }

//    @GET
//    public List<Employee> getEmployees(){
//        return employeeRepository.selectAll();
//    }
//
//    @GET @Path("{name}")
//    public List<Employee> getEmployeesByProject(@PathParam("name") String projectName){
//        Project project = projectRepository.getProjectByName(projectName);
//        return new ArrayList<>(project.getEmployees());
//    }
//
//    @PUT @Path("/project/{projectID}/add/{employeeID}")
//    public Project addEmployeeToProject(
//            @PathParam("projectID") int projectID,
//            @PathParam("employeeID") int employeeID
//    ){
//        Project project = projectRepository.findByID(projectID);
//        Employee employee = employeeRepository.findByID(employeeID);
//        project.addEmployee(employee);
//        return projectRepository.save(project);
//    }
}
