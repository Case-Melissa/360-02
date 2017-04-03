package com.example.melissacase.servlet;

/**
 * Created by Melissa Case on 3/29/2017.
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {

    Connection con = null;

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "sesame");//mysql database

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}