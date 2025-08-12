package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
    public static Connection getConnection() {
        String databaseUrl = "jdbc:mysql://localhost:3306/test_database";
        String username = "root";
        String password = "root";

        try {
            return DriverManager.getConnection(databaseUrl, username, password);
        } catch (Exception exception) {
            System.out.println("Lấy connection bị lỗi" + exception.getMessage());
        }

        return null;
    }


}
