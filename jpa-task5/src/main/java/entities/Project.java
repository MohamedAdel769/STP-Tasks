package entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "proj_ID")
    private int id;

    @Column(name = "project_name", nullable = false, unique = true, length = 50)
    private String projectName;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @ManyToOne
    @JoinColumn(name = "emp_ID")
    private Employee projectManager;

    @ManyToMany
    @JoinTable(
            name = "project_employee",
            joinColumns = {
                    @JoinColumn(name = "project_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "employee_id")
            }
    )
    private Set<Employee> employees = new HashSet<>();

    public Employee getProjectManager() {
        return projectManager;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Project() {
    }

    public Project(int id, String projectName, Date startDate, Employee projectManager) {
        this.id = id;
        this.projectName = projectName;
        this.startDate = startDate;
        this.projectManager = projectManager;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", projectManager=" + projectManager +
                '}';
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
