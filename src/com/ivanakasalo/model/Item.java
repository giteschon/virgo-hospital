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
public class Item {

    private int idItem;
    private Invoice invoice;
    private Medicine medicine;
    private Test test;
    private Consultation consultation;
    private Patient patient;
    private Date entryDate;

    public Item(int idItem, Invoice invoice, Medicine medicine, Test test, Consultation consultation, Patient patient, Date entryDate) {
        this.idItem = idItem;
        this.invoice = invoice;
        this.medicine = medicine;
        this.test = test;
        this.consultation = consultation;
        this.patient = patient;
        this.entryDate = entryDate;
    }

    public Item(Medicine medicine, Test test, Consultation consultation, Patient patient) {
        this.medicine = medicine;
        this.test = test;
        this.consultation = consultation;
        this.patient = patient;

    }

    public Item(int idItem, Medicine medicine, Test test, Consultation consultation, Patient patient, Date entryDate) {
        this.idItem = idItem;
        this.medicine = medicine;
        this.test = test;
        this.consultation = consultation;
        this.patient = patient;
        this.entryDate = entryDate;
    }

    public Item(Invoice invoice, Medicine medicine, Test test, Consultation consultation) {
        this.invoice = invoice;
        this.medicine = medicine;
        this.test = test;
        this.consultation = consultation;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

}
