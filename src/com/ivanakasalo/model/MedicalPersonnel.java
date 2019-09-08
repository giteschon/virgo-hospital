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
public class MedicalPersonnel extends Person {

    private Occupation occupation;

    public MedicalPersonnel(int id, String firstName, String middleName, String surname, Address presentAddress, Contact contact, Occupation occupation) {
        super(id, firstName, middleName, surname, presentAddress, contact);
        this.occupation = occupation;
    }

    public MedicalPersonnel(String firstName, String middleName, String surname, Address presentAddress, Contact contact, Occupation occupation) {
        super(firstName, middleName, surname, presentAddress, contact);
        this.occupation = occupation;
    }

    public MedicalPersonnel() {

    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

}
