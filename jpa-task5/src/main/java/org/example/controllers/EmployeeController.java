package org.example.controllers;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.repositories.EmployeeRepository;
import org.example.repositories.ProjectRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public EmployeeController(){
        employeeRepository = new EmployeeRepository();
        projectRepository = new ProjectRepository();
    }

    @GET
    @Path("/hello")
    public String testAPI(){
        return "Hello JAX-RS";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(){
        List<Employee> employees = employeeRepository.selectAll();
        return Response.ok(employees).build();
    }

    @GET
    @Path("/in/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByProject(@PathParam("name") String projectName){
        Project project = projectRepository.getProjectByName(projectName);
        return Response.ok(project.getEmployees()).build();
    }

    @PUT
    @Path("/project/{projectID}/add/{employeeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployeeToProject(
            @PathParam("projectID") int projectID,
            @PathParam("employeeID") int employeeID
    ){
        Project project = projectRepository.findByID(projectID);
        Employee employee = employeeRepository.findByID(employeeID);
        project.addEmployee(employee);
        projectRepository.save(project);
        return Response.ok(project.getEmployees()).build();
    }
}
