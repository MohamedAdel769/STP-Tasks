package com.sumerge;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

public class Appointment {
    private Patient patient;
    @Size(min=10, max=100, message="Name must be between 10 and 100 characters")
    private String doctorName;
    @FutureOrPresent(message="Date should not be in the past")
    private Date date;

    public Appointment(Patient patient, String d_name, Date date){
        this.patient = patient;
        this.doctorName = d_name;
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
