package org.example.controllers;

import org.example.dto.Page;
import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.services.EmployeeService;
import org.example.services.EntityFactoryService;
import org.example.services.ProjectService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("/employees")
public class EmployeeController {
    @Inject
    private EmployeeService employeeService;

    @Inject
    private ProjectService projectService;

    @POST
    @Path("/page")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response paginate(Page page){
        try {
            List<Employee> employees = employeeService.selectAllPage(page.getPageIndex(), page.getPageSize());
            return Response.ok(employees).build();
        }
        catch (Exception e) {
            return Response.status(404).build();
        }
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
        try{
            Set<Employee> employeeSet = projectService.getEmployees(projectName);
            return Response.ok(employeeSet).build();
        }
        catch (Exception e){
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("/project/{projectID}/add/{employeeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployeeToProject(
            @PathParam("projectID") int projectID,
            @PathParam("employeeID") int employeeID
    ){
        try {
            Employee employee = employeeService.findByID(employeeID);
            return Response.ok(projectService.addEmployeeToProject(employee, projectID)
                    .getEmployees()).build();
        }
        catch (Exception e){
            return Response.status(404).build();
        }
    }
}
