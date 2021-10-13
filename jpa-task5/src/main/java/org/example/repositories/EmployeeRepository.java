package org.example.repositories;

import org.example.entities.Employee;
import org.example.entities.Project;
import org.example.entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeRepository {
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    public EmployeeRepository(){
        emf = Persistence.createEntityManagerFactory("org.example.entities");
        entityManager = emf.createEntityManager();
    }

    public Employee findByID(int id){
        return entityManager.find(Employee.class, id);
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
        entityManager.close();
        emf.close();
    }
}
