package org.example.repository;

import entities.Employee;
import entities.Project;
import entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private final EntityManagerFactory emf;
    private final EntityManager entityManager;

    public EmployeeRepository(){
        this.emf = Persistence.createEntityManagerFactory("entities.Employee");
        this.entityManager = this.emf.createEntityManager();
    }

    public Employee getEmployee(int id){
        return entityManager.find(Employee.class, id);
    }
    public Role getRole(int id){
        return entityManager.find(Role.class, id);
    }

    public List<Employee> selectAll(){
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    public Project getProjectByName(String projectName){
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.projectName = :projectName");
        query.setParameter("projectName", projectName);
        return (Project) query.getSingleResult();
    }

    public Set<Employee> getEmployeesByProject(String projectName){
        return getProjectByName(projectName).getEmployees();
    }

    public void insertEmployee(Employee employee){
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public List<Employee> getIdleEmployees(Role role){
        List<Employee> employees = selectAll();
        return employees.stream().filter(employee ->
            employee.getProjectSet().size()==0 && employee.getRole().getId()==role.getId())
            .collect(Collectors.toList());
    }

    public void addEmployeetoProject(Employee newEmployee, String projectName){
        entityManager.getTransaction().begin();
        Project project = getProjectByName(projectName);
        Set<Employee> oldEmployees = project.getEmployees();
        if(oldEmployees.contains(newEmployee)){
            System.out.println("Employee already on this project!");
            return;
        }
        oldEmployees.add(newEmployee);
        project.setEmployees(oldEmployees);
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }
}
