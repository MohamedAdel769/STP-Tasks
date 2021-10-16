package org.example.controllers;

import org.apache.http.HttpStatus;
import org.example.dto.Page;
import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.services.EmployeeService;
import org.example.services.EntityFactoryService;
import org.example.services.ProjectService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock
    private EmployeeService employeeService;

    @Mock
    private ProjectService projectService;

    @InjectMocks
    EmployeeController controller;

    @Test
    void paginate() {
        int page = 1, limit = 1;
        List<Employee> dummy = Arrays.asList(
                new Employee(1, "test", "t@gmail.com", (short) 20),
                new Employee(2, "test 2", "t2@gmail.com", (short) 30));

        List<Employee> pageList = dummy.subList((page - 1) * limit, limit);
        when(employeeService.selectAllPage(page, limit))
                .thenReturn(pageList);

        Response response = controller.paginate(new Page(page, limit));
        //System.out.println(response.getEntity().toString());
        assertEquals(pageList.toString(), response.getEntity().toString());
    }

    @Test
    void getEmployees() {
        List<Employee> dummy = Arrays.asList(
                new Employee(1, "test", "t@gmail.com", (short) 20),
                new Employee(2, "test 2", "t2@gmail.com", (short) 30));

        when(employeeService.selectAll()).thenReturn(dummy);

        Response response = controller.getEmployees();
        assertEquals(dummy.toString(), response.getEntity().toString());
    }


    @Test
    void getEmployeesByProject() {
        Set<Employee> dummy = new HashSet<>();
        dummy.add(new Employee(1, "test", "t@gmail.com", (short) 20));

        when(projectService.getEmployees(anyString())).thenReturn(dummy);

        Response response = controller.getEmployeesByProject("any");
        assertEquals(dummy.toString(), response.getEntity().toString());
    }

    @Nested
    class addEmployeeToProject {

        @Test
        @DisplayName("When given project doesn't exist")
        void addEmployeeToUnknownProject() {
            Response response = controller.addEmployeeToProject(-1, 1);
            assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatus());
        }

        @Test
        @DisplayName("When given employee doesn't exist")
        void addUnknownEmployeeToProject() {
            Response response = controller.addEmployeeToProject(1, -1);
            assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatus());
        }

        @Test
        @DisplayName("When given project,employee exists")
        void validAddEmployeeToProject() throws Exception {
            Employee employee = new Employee(1, "test", "t@gmail.com", (short) 20);
            when(employeeService.findByID(anyInt())).thenReturn(employee);

            Project project = spy(Project.class);
            project.addEmployee(employee);
            when(projectService.addEmployeeToProject(employee, 1)).thenReturn(project);

            Response response = controller.addEmployeeToProject(1, 1);
            assertEquals(project.getEmployees().toString(), response.getEntity().toString());
            verify(project).addEmployee(employee);
        }
    }
}
