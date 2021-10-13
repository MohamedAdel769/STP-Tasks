package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Set;

public class ProjectService {

    public Project getProjectByName(String projectName){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName");
        query.setParameter("projectName", projectName);
        return (Project) query.getSingleResult();
    }

    public Set<Employee> getEmployees(String projectName){
        Project project = getProjectByName(projectName);
        return project.getEmployees();
    }

    public Project addEmployeeToProject(Employee employee, int projectID){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Project project = entityManager.find(Project.class, projectID);
        project.addEmployee(employee);

        entityManager.persist(project);
        entityManager.getTransaction().commit();
        return project;
    }

    public EntityManager getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.example.entities");
        return emf.createEntityManager();
    }
}
