package com.atguigu.connection;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    // 方式一
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

    // 方式二 -> 对方式一的迭代:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
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


    // 方式三 -> 使用DriverManager替换Driver
    @Test
    public void testConnection3() throws Exception {

        // 1. 获取Driver实现类的对象
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2. 提供三个基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取链接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);


        Assert.assertNotNull(conn);
    }

}














