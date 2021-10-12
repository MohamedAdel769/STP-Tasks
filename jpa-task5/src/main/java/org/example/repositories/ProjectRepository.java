package org.example.repositories;

import org.example.entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProjectRepository {
    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    public ProjectRepository(){
        emf = Persistence.createEntityManagerFactory("org.example.entities");
        entityManager = emf.createEntityManager();
    }

    public Project getProjectByName(String projectName){
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName");
        query.setParameter("projectName", projectName);
        return (Project) query.getSingleResult();
    }

    public Project findByID(int id){
        return entityManager.find(Project.class, id);
    }

    public Project save(Project project){
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        return project;
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
