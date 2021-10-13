package org.example.repositories;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.entities.Role;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRepository {
    EntityManagerFactory emf;
    EntityManager entityManager;

    public EmployeeRepository(){
        emf = Persistence.createEntityManagerFactory("org.example.entities");
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public Employee findByID(int id){
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> selectAll(){
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public void close(){
        entityManager.getTransaction().commit();
        entityManager.close();
        emf.close();
    }
}
