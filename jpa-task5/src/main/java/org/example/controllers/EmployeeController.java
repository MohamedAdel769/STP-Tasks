package org.example.controllers;

import org.example.dto.Page;
import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.services.EmployeeService;
import org.example.services.EntityFactoryService;
import org.example.services.ProjectService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeService(EntityFactoryService.getEntityManager());
    private final ProjectService projectService = new ProjectService(EntityFactoryService.getEntityManager());

    @POST
    @Path("/page")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response paginate(Page page){
        List<Employee> employees = employeeService.selectAllPage(page.getPageIndex(), page.getPageSize());
        return Response.ok(employees).build();
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
        Employee employee = employeeService.findByID(employeeID);
        return Response.ok(projectService.addEmployeeToProject(employee, projectID)
                .getEmployees()).build();
    }
}
