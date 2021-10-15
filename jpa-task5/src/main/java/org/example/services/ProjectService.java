package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Project;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Set;

public class ProjectService {
    @Inject
    private EntityManager entityManager;

    public ProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Set<Employee> getEmployees(String projectName){
        //EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName");
        query.setParameter("projectName", projectName);
        Project project = (Project) query.getSingleResult();
        return project.getEmployees();
    }

    public Project addEmployeeToProject(Employee employee, int projectID){
        //EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        Project project = entityManager.find(Project.class, projectID);
        project.addEmployee(employee);

        entityManager.persist(project);
        entityManager.getTransaction().commit();
        return project;
    }
}
