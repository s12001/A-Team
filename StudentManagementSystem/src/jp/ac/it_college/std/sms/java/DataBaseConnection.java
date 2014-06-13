package jp.ac.it_college.std.sms.java;

import java.sql.*;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private Connection mConnection;

    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            mConnection = DriverManager.getConnection(
                    "jdbc:mysql://172.16.40.3/pbl", "pbl", "itcollege"
            );
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Statement getStatement() {
        Statement statement = null;
        try {
            statement = mConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = mConnection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
