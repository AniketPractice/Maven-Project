package com.company.common;

import org.junit.Test;

import java.sql.Connection;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UtilityTest {

    @Test
    public void testGetConnection_withValidProperties() {
        // Create mock properties with valid database connection details
        Properties properties = new Properties();
        properties.setProperty("database.url", "jdbc:mysql://localhost:3306/test_db");
        properties.setProperty("database.username", "root");
        properties.setProperty("database.password", "Root");

        // Call the getConnection method
        Connection connection = Utility.getConnection(properties);

        // Assert that the connection is not null
        assertNotNull("Connection should not be null with valid properties", connection);

        // Close the connection
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetConnection_withMissingProperties() {
        // Create mock properties with missing database connection details
        Properties properties = new Properties();
        properties.setProperty("database.url", "jdbc:mysql://localhost:3306/test_db");

        // Call the getConnection method
        Connection connection = Utility.getConnection(properties);

        // Assert that the connection is null due to missing properties
        assertNull("Connection should be null when properties are missing", connection);
    }
}
