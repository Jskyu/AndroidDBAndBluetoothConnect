package com.example.myapplication;

import com.example.myapplication.config.DBConnection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection2 {

    @Test
    public void DBConnection2() throws SQLException {
        Connection conn = DBConnection.getConn();

        Statement st = conn.createStatement();

        String sql = "INSERT INTO EXAMTB (ID, NAME) VALUE (5, \"PLZ\")";
        System.out.println("st.execute(sql) = " + st.execute(sql));

    }
}