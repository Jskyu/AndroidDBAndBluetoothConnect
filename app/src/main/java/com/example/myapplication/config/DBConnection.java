package com.example.myapplication.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConn() {
        Connection conn = null;
        try {
            String url = "jdbc:mariadb://localhost:3306/aostest";
            String user = "root";
            String pw = "1234";

            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}