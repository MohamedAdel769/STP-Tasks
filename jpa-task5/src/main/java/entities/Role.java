package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "roles_ID")
    private int id;

    @Column(name = "role_name", nullable = false, length = 100)
    private String roleName;

    @Column(name = "department", nullable = false, length = 50)
    private String department;

    public Role() {
    }

    public Role(int id, String roleName, String department, List<Employee> employees) {
        this.id = id;
        this.roleName = roleName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
