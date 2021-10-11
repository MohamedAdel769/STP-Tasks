package entities;

import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "age", nullable = false)
    private short age;

    @Column(name = "national_ID", nullable = false, unique = true, length = 14)
    private String nationalID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Role role;

    @OneToMany(mappedBy = "employee")
    private List<Project> managedProjects = new ArrayList<>();

    public List<Project> getManagedProjects() {
        return managedProjects;
    }

    public void setManagedProjects(List<Project> managedProjects) {
        this.managedProjects = managedProjects;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
}
