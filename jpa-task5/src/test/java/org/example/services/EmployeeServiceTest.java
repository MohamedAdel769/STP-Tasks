package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Role;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EntityManager em;

    @InjectMocks
    EmployeeService employeeService;

    @Nested
    class FindByID {

        @Test
        @DisplayName("When passing existed ID")
        void findByKnownID() {
            Employee dummyEmployee = new Employee(1,"Adel", "ma@gmail.com", (short) 30);
            Mockito.when(em.find(Employee.class, 1)).thenReturn(dummyEmployee);
            assertEquals(dummyEmployee.getFullName(), employeeService.findByID(1).getFullName());
        }

        @Test
        @DisplayName("When passing non existed ID")
        void findByUnknownID() {
            Mockito.when(em.find(any(Class.class), Mockito.anyInt())).thenReturn(null);
            assertNull(employeeService.findByID(1234));
        }
    }


    @Test
    void selectAll() {
        List<Employee> dummyEmployees = Arrays.asList(
          new Employee(1,"test", "ma@gmail.com", (short) 30),
                new Employee(2,"Adel", "ma123@hotmail.com", (short) 20)
        );

        String queryStr = "SELECT e FROM Employee e";
        TypedQuery<Employee> query = (TypedQuery<Employee>) Mockito.mock(TypedQuery.class);

        when(em.createQuery(queryStr)).thenReturn(query);
        when(query.getResultList()).thenReturn(dummyEmployees);

        List<Employee> actualList = employeeService.selectAll();
        assertEquals(dummyEmployees, actualList);
        verify(em).createQuery(queryStr);
        verify(query).getResultList();
    }

    @Test
    void selectAllPage() {
        List<Employee> expected = Arrays.asList(new Employee(1,"test", "ma@gmail.com", (short) 30));
        TypedQuery<Employee> query = (TypedQuery<Employee>) Mockito.mock(TypedQuery.class);

        when(em.createQuery("SELECT e FROM Employee e")).thenReturn(query);
        when(query.setFirstResult(anyInt())).thenReturn(query);
        when(query.setMaxResults(anyInt())).thenReturn(query);
        when(query.getResultList()).thenReturn(expected);

        List<Employee> actual = employeeService.selectAllPage(1, 1);
        assertEquals(1, actual.size());
        verify(query).setFirstResult(0);
        verify(query).setMaxResults(1);
        verify(query).getResultList();
    }
}
