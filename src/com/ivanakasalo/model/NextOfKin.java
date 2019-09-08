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
public class NextOfKin extends Person {

    private Relationship relationship;

    public NextOfKin(int id, String firstName, String middleName, String surname, Address presentAddress, Relationship relationship, Contact contact) {
        super(id, firstName, middleName, surname, presentAddress, contact);
        this.relationship = relationship;
    }

    public NextOfKin(String firstName, String middleName, String surname, Address presentAddress, Relationship relationship, Contact contact) {
        super(firstName, middleName, surname, presentAddress, contact);
        this.relationship = relationship;
    }

    public NextOfKin(String firstName, String middleName, String surname, Relationship relationship) {
        super(firstName, middleName, surname);
        this.relationship = relationship;
    }

    public NextOfKin() {

    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

}
