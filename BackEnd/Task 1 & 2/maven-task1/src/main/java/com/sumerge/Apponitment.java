package com.sumerge;

import java.util.Date;

public class Apponitment {
    private Patient patient;
    private String doctorName;
    private Date date;

    public Apponitment(Patient patient, String d_name, Date date){
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
