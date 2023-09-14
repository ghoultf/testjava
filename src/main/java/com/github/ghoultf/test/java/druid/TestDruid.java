package com.github.ghoultf.test.java.druid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alibaba.druid.pool.DruidDataSource;

public class TestDruid {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(
            "jdbc:mysql://192.168.2.104:3306/sio-20230504?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("hzct");

        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sys_user_sio")) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("username");
                String password = rs.getString("nick_name");
                // 处理结果集行数据
                System.out.println(id + name + password);
            }
        }

        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM sys_user_sio")) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("username");
                String password = rs.getString("nick_name");
                // 处理结果集行数据
                System.out.println(id + name + password);
            }
        }

    }
}
