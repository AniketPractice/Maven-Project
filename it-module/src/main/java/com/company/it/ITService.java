package com.company.it;

import com.company.common.ConfigurationLoader;
import com.company.common.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ITService {

    public  boolean giveAccess(String employeeName) {
        // Basic input validation
        if (employeeName == null || employeeName.trim().isEmpty()) {
            return false;
        }

        // Load properties from config.properties file
        ConfigurationLoader configLoader = new ConfigurationLoader();
        Properties properties = configLoader.loadPropertiesFile("config.properties");

        String query = "INSERT INTO system_access (name, access_level) VALUES (?, 'User')";
        try (Connection connection = Utility.getConnection(properties);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employeeName);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("System access granted to employee: " + employeeName);
                return true;
            } else {
                System.out.println("Failed to grant access to employee: " + employeeName);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
