/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanakasalo.dal.sql;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

/**
 *
 * @author office10
 */
public class DataSourceSingleton {

    private static final String SQL = "SQL";
    private static final String SA = "sa";
    private static final String VIRGOHOSPITAL = "VirgoHospital";
    private static final String LOCALHOST = "localhost";

    private static DataSource instance;

    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(LOCALHOST);
        dataSource.setDatabaseName(VIRGOHOSPITAL);
        dataSource.setUser(SA);
        dataSource.setPassword(SQL);

        return dataSource;

    }

    //konstruktor zasticen
    private DataSourceSingleton() {

    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }

        return instance;
    }
}
