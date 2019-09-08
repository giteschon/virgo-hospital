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
public class BloodType {

    private int idBloodType;
    private String bloodType;

    public BloodType(int idBloodType, String bloodType) {
        this.idBloodType = idBloodType;
        this.bloodType = bloodType;
    }

    public int getIdBloodType() {
        return idBloodType;
    }

    public void setIdBloodType(int idBloodType) {
        this.idBloodType = idBloodType;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return bloodType;
    }

}
