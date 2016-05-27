package com.varentech.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by ParksW on 5/25/2016.
 */
public class ConnectionConfiguration {

    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:TEST.db");
            System.out.println("Connection successful!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
