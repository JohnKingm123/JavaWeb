package com.jkm.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo_Login {
    @Test
    public void LoginTest() throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3306/db0?useSSL=false";
        String DBuser = "root";
        String DBpassword = "411378";

        Connection conn = DriverManager.getConnection(url,DBuser,DBpassword);
        Statement statmt = conn.createStatement();

        String user = "JK";
        String password = "411378";

        //String haxUser = "asdasdad";//SQL insert ATK
        //String haxPassword = "'or'1'='1";

        String sql = "SELECT * FROM user WHERE username = '"+user+"' and password ='"+password+"';";

        ResultSet ret = statmt.executeQuery(sql);

        if(ret.next()){
            System.out.println("Success");
        }else{
            System.out.println("fail");
        }

        ret.close();
        statmt.close();
        conn.close();
    }
}
