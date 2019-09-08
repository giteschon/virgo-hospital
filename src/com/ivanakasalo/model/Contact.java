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
public class Contact {

    private int idContact;
    private String contactDetail;
    private ContactType contactType;

    public Contact(int idContact, String contactDetail, ContactType contactType) {
        this.idContact = idContact;
        this.contactDetail = contactDetail;
        this.contactType = contactType;
    }

    public Contact(String contactDetail, ContactType contactType) {
        this.contactDetail = contactDetail;
        this.contactType = contactType;
    }

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

}
