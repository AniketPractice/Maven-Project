package com.company.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utility {

    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(Utility.class);

    public static Connection getConnection(Properties prop) {
        Connection connection = null;

        // Retrieve database configuration from the passed properties
        String url = prop.getProperty("database.url");
        String username = prop.getProperty("database.username");
        String password = prop.getProperty("database.password");

        if (url == null || username == null || password == null) {
            logger.error("Database connection properties are missing.");
            return null; // Return null if properties are missing
        }

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

        } catch (SQLException e) {
            logger.error("Unable to connect to the database.", e);
        } catch (ClassNotFoundException e) {
            logger.fatal("MySQL JDBC Driver not found", e);
        }

        return connection;
    }
}
