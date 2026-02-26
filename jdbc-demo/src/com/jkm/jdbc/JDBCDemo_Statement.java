package com.jkm.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo_Statement {
    @Test
    public void DDLTest() throws Exception{

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db0","root","411378");

        String sql ="CREATE DATABASE db1;";

        Statement statmt = conn.createStatement();

        int OperatedRowCount = statmt.executeUpdate(sql);

        if(OperatedRowCount>0){
            System.out.println("Done");
        }else{
            System.out.println("Failed");
        }

        statmt.close();
        conn.close();
    }
}
