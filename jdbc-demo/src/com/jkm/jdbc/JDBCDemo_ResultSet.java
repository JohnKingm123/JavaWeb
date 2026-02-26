package com.jkm.jdbc;

import com.jkm.pojo.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo_ResultSet {
    @Test
    public void ResultSet() throws Exception{
        String url="jdbc:mysql:///db0?useSSL=false";
        String user="root";
        String DBpassword="411378";
        Connection conn = DriverManager.getConnection(url,user,DBpassword);

        String sql = "SELECT * FROM user;";
        Statement statmt = conn.createStatement();
        ResultSet ret = statmt.executeQuery(sql);

        while(ret.next()){
            int id = ret.getInt("id");
            String usrname = ret.getString("username");
            String pasword = ret.getString("password");

            System.out.println(id);
            System.out.println(usrname);
            System.out.println(pasword);
            System.out.println("_____________________________");
        }
        ret.close();
        statmt.close();
        conn.close();
    }

    @Test
    public void ResultSetEncapsulation() throws Exception{
        String url="jdbc:mysql:///db0?useSSL=false";
        String user="root";
        String DBpassword="411378";
        List<Account> userList = new ArrayList<Account>();
        Connection conn = DriverManager.getConnection(url,user,DBpassword);

        String sql = "SELECT * FROM user;";
        Statement statmt = conn.createStatement();
        ResultSet ret = statmt.executeQuery(sql);

        while(ret.next()){
            Account userAccount = new Account();

            int id = ret.getInt("id");
            String username = ret.getString("username");
            String password = ret.getString("password");

            userAccount.setId(id);
            userAccount.setUsername(username);
            userAccount.setPassword(password);

            userList.add(userAccount);
        }

        System.out.println(userList);

        ret.close();
        statmt.close();
        conn.close();
    }
}
