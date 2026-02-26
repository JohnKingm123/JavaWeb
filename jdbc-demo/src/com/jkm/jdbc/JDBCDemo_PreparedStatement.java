package com.jkm.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCDemo_PreparedStatement {//
@Test
    public void PreparedStatementTest() throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3306/db0?useSSL=false";
        String DBuser = "root";
        String DBpassword = "411378";

        Connection conn = DriverManager.getConnection(url,DBuser,DBpassword);

        String user = "JK";
        String password = "411378";

//        String haxUser = "asdasdad";//SQL insert ATK
//        String haxPassword = "'or'1'='1";

        String sql = "SELECT * FROM user WHERE username = ? and password =?;";

        PreparedStatement predStatmt = conn.prepareStatement(sql);
        predStatmt.setString(1,user);
        predStatmt.setString(2,password);

        ResultSet ret = predStatmt.executeQuery();

        if(ret.next()){
            System.out.println("Success");
        }else{
            System.out.println("fail");
        }

        ret.close();
        predStatmt.close();
        conn.close();
    }
    @Test

    public void PreparedStatementTest2() throws Exception{
        String url = "jdbc:mysql://127.0.0.1:3306/db0?useSSL=false&useServerPrepStmts=true";
        String DBuser = "root";
        String DBpassword = "411378";
        ResultSet ret = null;

        Connection conn = DriverManager.getConnection(url,DBuser,DBpassword);
        String user = "JK";
        String password = "411378";
//        String user = "asdasdad";//SQL insert ATK
//        String password = "'or'1'='1";

        String sql = "SELECT * FROM user WHERE username = ? and password =?;";

        PreparedStatement predStatmt = conn.prepareStatement(sql);
        predStatmt.setString(1,user);
        predStatmt.setString(2,password);

        ret = predStatmt.executeQuery();

        if(ret.next()){
            System.out.println("Success");
        }else{
            System.out.println("fail");
        }

        ret.close();
        predStatmt.close();
        conn.close();
    }
}