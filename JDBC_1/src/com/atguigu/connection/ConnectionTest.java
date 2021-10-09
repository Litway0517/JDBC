package com.atguigu.connection;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    @Test
    public void testConnection1() throws SQLException {


        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);

        Assert.assertNotNull(conn);


    }

    @Test
    public void testConnection2() throws Exception {
        // 1. 获取Driver实现类对象: 使用反射
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        

        // 2. 提供要链接的数据
        String url = "jdbc:mysql://localhost:3306/test";


        // 3. 提供连接需要使用的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);

        Assert.assertNotNull(conn);
    }


}
