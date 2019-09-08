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
public class ContactType {

    private int idContactType;
    private String type;

    public ContactType(int idContactType, String type) {
        this.idContactType = idContactType;
        this.type = type;
    }

    public int getIdContactType() {
        return idContactType;
    }

    public void setIdContactType(int idContactType) {
        this.idContactType = idContactType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
