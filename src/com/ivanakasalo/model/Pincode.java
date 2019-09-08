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
public class Pincode {

    private int idPincode;
    private String value;
    private City city;
    private String area;

    public Pincode(int idPincode, String value, City city, String area) {
        this.idPincode = idPincode;
        this.value = value;
        this.city = city;
        this.area = area;
    }

    public int getIdPincode() {
        return idPincode;
    }

    public void setIdPincode(int idPincode) {
        this.idPincode = idPincode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return value;
    }

}
