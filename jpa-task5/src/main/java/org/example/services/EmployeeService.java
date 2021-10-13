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

    public List<Employee> selectAllPage(int page, int limit){
        int offset = (page-1) * limit;
        EntityManager entityManager = getEntityManager();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e", Employee.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

        return employees;
    }

    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.example.entities");
        return emf.createEntityManager();
    }
}
