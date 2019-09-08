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
public class Relationship {

    private int idRelationship;
    private String name;

    public Relationship(int idRelationship, String name) {
        this.idRelationship = idRelationship;
        this.name = name;
    }

    public int getIdRelationship() {
        return idRelationship;
    }

    public void setIdRelationship(int idRelationship) {
        this.idRelationship = idRelationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
