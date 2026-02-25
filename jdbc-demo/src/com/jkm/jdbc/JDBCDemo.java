package com.jkm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db0","root","411378");

        String sql ="UPDATE user set `password` = '411378' WHERE id = 0;";

        Statement statmt = conn.createStatement();

        int OperatedRowCount = statmt.executeUpdate(sql);

        statmt.close();
        conn.close();
    }
}
