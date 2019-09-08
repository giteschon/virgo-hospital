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
public class MaritalStatus {

    private int idMaritalStatus;
    private String status;

    public MaritalStatus(int idMaritalStatus, String status) {
        this.idMaritalStatus = idMaritalStatus;
        this.status = status;
    }

    public int getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(int idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

}
