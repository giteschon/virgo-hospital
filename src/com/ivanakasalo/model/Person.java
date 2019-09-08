/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.model;

/**
 *
 * @author Ivana
 */
public abstract class Person {

    private int id;
    private String firstName;
    private String middleName;
    private String surname;
//    private Sex sex;
//    private Date dateofBirth;
    private Address presentAddress;
    private Contact contact;

    public Person(int id, String firstName, String middleName, String surname, Address presentAddress, Contact contact) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.presentAddress = presentAddress;
        this.contact = contact;
    }

    public Person(String firstName, String middleName, String surname, Address presentAddress, Contact contact) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.presentAddress = presentAddress;
        this.contact = contact;
    }

    public Person(String firstName, String middleName, String surname) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
    }

    public Person(String firstName, String middleName, String surname, Contact contact) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.contact = contact;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(Address presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
