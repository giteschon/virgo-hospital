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
public class Invoice {

    private int idInvoice;
    private String invoiceNo;
    private Patient patient;
    private PaymentType paymentType;
    private double sum;
    private Date date;

    public Invoice(int idInvoice, String invoiceNo, Patient patient, PaymentType paymentType, double sum, Date date) {
        this.idInvoice = idInvoice;
        this.invoiceNo = invoiceNo;
        this.patient = patient;
        this.paymentType = paymentType;
        this.sum = sum;
        this.date = date;
    }

    public Invoice(String invoiceNo, Patient patient, PaymentType paymentType, double sum, Date date) {
        this.invoiceNo = invoiceNo;
        this.patient = patient;
        this.paymentType = paymentType;
        this.sum = sum;
        this.date = date;
    }

    public Invoice(String invoiceNo, Patient patient, PaymentType paymentType, double sum) {
        this.invoiceNo = invoiceNo;
        this.patient = patient;
        this.paymentType = paymentType;
        this.sum = sum;
    }

    public Invoice() {

    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
