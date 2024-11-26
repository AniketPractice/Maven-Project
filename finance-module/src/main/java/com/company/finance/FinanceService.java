package com.company.finance;

import com.company.common.ConfigurationLoader;
import com.company.common.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class FinanceService {


    public boolean processPayroll(String employeeName, double salary) {

        if (employeeName == null || employeeName.trim().isEmpty() || salary < 0) {
            return false;
        }


        // Load properties from config.properties file
        ConfigurationLoader configLoader = new ConfigurationLoader();
        Properties properties = configLoader.loadPropertiesFile("config.properties");

        String query = "INSERT INTO payroll (name, salary) VALUES (?, ?)";
        try (Connection connection = Utility.getConnection(properties);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employeeName);
            statement.setDouble(2, salary);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Payroll processed for employee: " + employeeName);
                return true;
            } else {
                System.out.println("Failed to process payroll for employee: " + employeeName);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
