package org.example.controllers;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.services.EmployeeService;
import org.example.services.ProjectService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeService();
    private final ProjectService projectService = new ProjectService();

    @GET
    @Path("/hello")
    public String testAPI(){
        return "Hello JAX-RS";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployees(){
        return Response.ok(employeeService.selectAll()).build();
    }

    @GET
    @Path("/in/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeesByProject(@PathParam("name") String projectName){
        return Response.ok(projectService.getEmployees(projectName)).build();
    }

    @PUT
    @Path("/project/{projectID}/add/{employeeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployeeToProject(
            @PathParam("projectID") int projectID,
            @PathParam("employeeID") int employeeID
    ){
        return Response.ok(projectService.addEmployeeToProject(employeeID, projectID)
                .getEmployees()).build();
    }
}
