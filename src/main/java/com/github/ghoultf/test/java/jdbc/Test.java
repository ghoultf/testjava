package com.github.ghoultf.test.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) throws SQLException {
        test();
        testTransaction();
    }

    private static void testTransaction() throws SQLException {
        Connection connection = null;
        try {
            connection.setAutoCommit(false);
            // ...
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void test() throws SQLException {
        DataSource ds = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("");
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
