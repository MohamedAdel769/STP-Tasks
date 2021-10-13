package org.example.services;

import org.example.entities.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class EmployeeService{

    public Employee findByID(int id){
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> selectAll(){
        EntityManager entityManager = getEntityManager();
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.example.entities");
        return emf.createEntityManager();
    }
}
