package org.example.cricket_stats_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to handle database connections
public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/cricket_stats_new"; // Database URL
    private static final String USER = "root"; // Database user
    private static final String PASSWORD = ""; // Database password

    // Method to establish a connection to the database
    public Connection connect() throws SQLException {
        // Return a connection to the database using the URL, user, and password
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
