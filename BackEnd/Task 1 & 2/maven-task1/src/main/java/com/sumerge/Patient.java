package com.sumerge;

import javax.validation.constraints.*;

public class Patient {
    @Size(min = 10, max = 100, message="Name must be between 10 and 100 characters")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Pattern(regexp = "\\d+(\\s\\w+)+", message = "Address should contain street number followed by st. name")
    private String address;
    @Positive(message = "Age should be positive number")
    @Max(value = 150, message = "Age should be 150 maximum")
    private int age;

    public Patient(String name, String email, String address, int age){
        this.name = name;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
