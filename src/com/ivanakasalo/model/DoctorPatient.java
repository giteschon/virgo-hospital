/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.model;

import java.sql.Date;

/**
 *
 * @author Ivy
 */
public class DoctorPatient {

    private int id;
    private Doctor doctor;
    private Patient patient;
    private Date dateOfTreatment;

    public DoctorPatient(int id, Doctor doctor, Patient patient, Date dateOfTreatment) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.dateOfTreatment = dateOfTreatment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDateOfTreatment() {
        return dateOfTreatment;
    }

    public void setDateOfTreatment(Date dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }

}
