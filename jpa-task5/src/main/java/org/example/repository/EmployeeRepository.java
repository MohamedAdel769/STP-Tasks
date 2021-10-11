package org.example.repository;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

public class EmployeeRepository {
    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    public EmployeeRepository(){
        this.emf = Persistence.createEntityManagerFactory("entities.Employee");
        this.entityManager = this.emf.createEntityManager();
    }

    public Employee find(int id){
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> selectAll(){
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public Project getProjectByName(String projectName){
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName");
        query.setParameter("projectName", projectName);
        return (Project) query.getSingleResult();
    }

    public List<Employee> getEmployeesByProject(String projectName){
        return getProjectByName(projectName).getEmployees();
    }

    public void insertEmployee(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void addEmployeetoProject(Employee newEmployee, String projectName){
        Project project = getProjectByName(projectName);
        List<Employee> oldEmployees = project.getEmployees();
        oldEmployees.add(newEmployee);
        project.setEmployees(oldEmployees);
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
