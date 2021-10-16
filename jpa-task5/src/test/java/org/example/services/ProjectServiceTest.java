package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private EntityManager em;

    @Mock
    private EntityTransaction transaction;

    @InjectMocks
    ProjectService projectService;

    @Test
    void getEmployees() {
        Project dummy = new Project(1, "test project");
        Query query = Mockito.mock(Query.class);

        when(em.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName")).thenReturn(query);
        when(query.getSingleResult()).thenReturn(dummy);
        assertEquals(dummy.getEmployees(), projectService.getEmployees("any name"));
    }

    @Test
    void addEmployeeToProject() throws Exception{
        Project dummy = new Project(1, "test project");
        Employee employee = new Employee(1,"test", "ma@gmail.com", (short) 30);

        when(em.getTransaction()).thenReturn(transaction);
        when(em.find(any(Class.class), Mockito.anyInt())).thenReturn(dummy);
        Project projectSpy = spy(Project.class);
        projectSpy.addEmployee(employee);

        Project actual = projectService.addEmployeeToProject(employee, 2);
        assertEquals(1, actual.getEmployees().size());
        verify(projectSpy).addEmployee(employee);
    }
}
