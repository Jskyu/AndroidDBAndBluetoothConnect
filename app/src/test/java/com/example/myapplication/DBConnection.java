package com.example.myapplication;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    @Test
    public void DBConnection() {
        StringBuffer sb = new StringBuffer();
        Connection con = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "1234");
            Statement st = null;
            ResultSet rs = null;

            st = con.createStatement();

            if (st.execute("SHOW DATABASES")) {
                rs = st.getResultSet();
            }

            while (rs.next()) {
                String str = rs.getString(1);
                sb.append(str);
                sb.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        String temp = sb.toString();
        System.out.println(temp);
    }
}
