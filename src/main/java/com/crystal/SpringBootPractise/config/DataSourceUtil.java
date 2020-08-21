package com.crystal.SpringBootPractise.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DataSourceUtil {
    private static final String HOST = "localhost";

    private static final int PORT = 3306;

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "123456";

    public static DataSource createDataSource1(final String dataSourceName) {
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName("com.mysql.cj.jdbc.Driver");
        result.setJdbcUrl(String.format("jdbc:mysql://localhost:3306/transtest?useSSL=false&serverTimezone=UTC", HOST, PORT, dataSourceName));
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }

    public static DataSource createDataSource2(final String dataSourceName) {
        HikariDataSource result = new HikariDataSource();
        result.setDriverClassName("com.mysql.cj.jdbc.Driver");
        result.setJdbcUrl(String.format("jdbc:mysql://localhost:3306/weixin?useSSL=false&serverTimezone=UTC", HOST, PORT, dataSourceName));
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }
}
