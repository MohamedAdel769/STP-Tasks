package org.example.services;

import org.example.entities.Employee;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class EmployeeService{

    @Inject
    private EntityManager entityManager;

    public EmployeeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee findByID(int id){
        //EntityManager entityManager = getEntityManager();
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> selectAll(){
       // EntityManager entityManager = getEntityManager();
        TypedQuery<Employee> query = (TypedQuery<Employee>) entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    public List<Employee> selectAllPage(int page, int limit){
        int offset = (page-1) * limit;
        //EntityManager entityManager = getEntityManager();
        TypedQuery<Employee> query = (TypedQuery<Employee>) entityManager.createQuery("SELECT e FROM Employee e").setFirstResult(offset);
        List<Employee> employees = query
                .setMaxResults(limit)
                .getResultList();

        return employees;
    }
}
