package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "project_name", nullable = false, unique = true, length = 50)
    private String projectName;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @ManyToOne()
    @JoinColumn(name = "ID")
    private Employee projectManager;

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
