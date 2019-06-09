package com.ranck.study.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    /**
     * 获取Connection
     * @return 所获得的Connection
     */

    public static Connection getConnection () throws Exception {

//        InputStream inputStream = JDBCUtil.class.getResourceAsStream("db.properties");
//        Properties properties = new Properties();
//        System.out.println(inputStream);  // null 搞求不懂 NullPointerException
//        properties.load(inputStream);   // NullPointerException


//        String url = properties.getProperty("jdbc.url");
//        String user = properties.getProperty("jdbc.username");
//        String password = properties.getProperty("jdbc.password");
//        String DriverClass = properties.getProperty("jdbc.DriverClass");

        String url = "jdbc:mysql://localhost:3306/boot_study?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
        String user = "root";
        String password = "root";
        String DriverClass = "com.mysql.cj.jdbc.Driver";

        Class.forName(DriverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * 释放数据库连击资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
