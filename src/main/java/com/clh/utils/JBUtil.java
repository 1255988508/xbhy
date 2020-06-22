package com.clh.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JBUtil {
    private static DruidDataSource druidDataSource;

    static {
        InputStream is = JBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            druidDataSource = new DruidDataSource();
            druidDataSource.setUsername(properties.getProperty("jdbc.username"));
            druidDataSource.setPassword(properties.getProperty("jdbc.password"));
            druidDataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
            druidDataSource.setUrl(properties.getProperty("jdbc.url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDruidDataSource() {
        return druidDataSource;
    }
}
