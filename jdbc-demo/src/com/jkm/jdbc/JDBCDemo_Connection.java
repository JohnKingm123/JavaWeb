package com.jkm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo_Connection {
    public static void main(String[] args) throws Exception{
        //Class.forName("com.mysql.cj.jdbc.Driver"); NODE

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db0","root","411378");
        String sql1 ="UPDATE user set `password` = '41137' WHERE id = 0;";
        String sql2 ="UPDATE user set `passwor` = '123123' WHERE id = 7;";
        Statement statmt = conn.createStatement();

        conn.setAutoCommit(false);

        try {// COMMIT
            int OperatedRowCount1 = statmt.executeUpdate(sql1);//successed
            System.out.println(OperatedRowCount1);
            int OperatedRowCount2 = statmt.executeUpdate(sql2);//failed and thorw out "e" and ROLL BACK
            System.out.println(OperatedRowCount2);

            conn.commit();
        } catch (Exception e) {//ROLL BACK
            conn.rollback();
            throw new RuntimeException(e);
        }

        statmt.close();
        conn.close();
    }
}
