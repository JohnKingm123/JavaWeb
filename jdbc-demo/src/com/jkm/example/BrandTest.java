package com.jkm.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.jkm.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {//insert del update Query

    @Test
    public void QueryAllTest() throws Exception {//SELECT * FROM tb_brand;
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        String sql = "SELECT * FROM tb_brand;";
        PreparedStatement predStatmt = conn.prepareStatement(sql);
        ResultSet ret = predStatmt.executeQuery();

        List<Brand> brandList = new ArrayList<>();
        Brand brand = null;

        while (ret.next()) {
            int id = ret.getInt("id");
            String brandName = ret.getString("brand_name");
            String companyName = ret.getString("company_name");
            int ordered = ret.getInt("ordered");
            String description = ret.getString("description");
            int status = ret.getInt("status");

            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setDescription(description);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setStatus(status);

            brandList.add(brand);
        }

        System.out.println(brandList);

        ret.close();
        predStatmt.close();
        conn.close();

        //        System.out.println(System.getProperty("user.dir"));
//        System.out.println(conn);
    }

    @Test
    public void InsertTest() throws Exception {
        String brandName = "香飘飘热饮";
        String companyName = "香飘飘食品有限公司";
        int ordered = 47;
        String description = "绕一圈";
        int status = 1;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) VALUES (?,?,?,?,?);";
        PreparedStatement predStatmt = conn.prepareStatement(sql);
        predStatmt.setString(1, brandName);
        predStatmt.setString(2, companyName);
        predStatmt.setInt(3, ordered);
        predStatmt.setString(4, description);
        predStatmt.setInt(5, status);

        int updatedRowCount = predStatmt.executeUpdate();

        System.out.println(updatedRowCount > 0);

        predStatmt.close();
        conn.close();
    }

    @Test
    public void UpdateTest() throws Exception {
        String brandName = "香飘飘热饮";
        String companyName = "香飘飘食品有限公司";
        int ordered = 4700;
        String description = "绕一圈";
        int status = 0;

        int id = 4;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        String sql = "UPDATE tb_brand SET brand_name = ?,company_name = ?,ordered = ?,description = ?,status = ? WHERE id = ?";
        PreparedStatement predStatmt = conn.prepareStatement(sql);
        predStatmt.setString(1, brandName);
        predStatmt.setString(2, companyName);
        predStatmt.setInt(3, ordered);
        predStatmt.setString(4, description);
        predStatmt.setInt(5, status);
        predStatmt.setInt(6, id);

        int updatedRowCount = predStatmt.executeUpdate();

        System.out.println(updatedRowCount > 0);

        predStatmt.close();
        conn.close();
    }

    @Test
    public void DeleteTest() throws Exception {
        int id = 4;

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        String sql = "DELETE FROM tb_brand WHERE id = ?";
        PreparedStatement predStatmt = conn.prepareStatement(sql);
        predStatmt.setInt(1, id);

        int updatedRowCount = predStatmt.executeUpdate();

        System.out.println(updatedRowCount > 0);

        predStatmt.close();
        conn.close();
    }
}