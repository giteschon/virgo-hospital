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
public class Address {

    private int idAddress;
    private String street;
    private String doorNo;
    private Pincode pincode;

    public Address(int idAddress, String street, String doorNo, Pincode pincode) {
        this.idAddress = idAddress;
        this.street = street;
        this.doorNo = doorNo;
        this.pincode = pincode;
    }

    public Address(String street, String doorNo, Pincode pincode) {
        this.street = street;
        this.doorNo = doorNo;
        this.pincode = pincode;
    }

    public Address() {

    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

}
