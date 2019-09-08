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
public class Sex {

    private int idSex;
    private String sex;

    public int getIdSex() {
        return idSex;
    }

    public Sex(int idSex, String sex) {
        this.idSex = idSex;
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setIdSex(int idSex) {
        this.idSex = idSex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return sex;
    }

}
