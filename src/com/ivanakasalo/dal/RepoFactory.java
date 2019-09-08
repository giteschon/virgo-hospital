/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.dal;

/**
 *
 * @author Ivana
 */
public final class RepoFactory {

    public static IRepo getRepo() {
        return new SqlRepo();

    }

}
