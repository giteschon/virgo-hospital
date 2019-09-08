/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.model;

/**
 *
 * @author Ivy
 */
public class Doctor extends Person {

    private boolean available;

    public Doctor(int id, String firstName, String middleName, String surname, Address presentAddress, Contact contact, boolean available) {
        super(id, firstName, middleName, surname, presentAddress, contact);
        this.available = available;
    }

    public Doctor(String firstName, String middleName, String surname, Address presentAddress, Contact contact, boolean available) {
        super(firstName, middleName, surname, presentAddress, contact);
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
