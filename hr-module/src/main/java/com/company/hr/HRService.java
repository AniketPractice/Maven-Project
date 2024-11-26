//package com.company.hr;
//
//import com.company.common.Utility;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class HRService {
//
//    public boolean onboardEmployee(String employeeName, String departmentName) {
//        if (employeeName == null || employeeName.trim().isEmpty()) {
//            return false;
//        }
//
//        String query = "INSERT INTO employee (name, department) VALUES (?, ?)";
//        try (Connection connection = Utility.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//
//            statement.setString(1, employeeName);
//            statement.setString(2, departmentName);
//
//            int rowInserted = statement.executeUpdate();
//            return rowInserted > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
//

package com.company.hr;

import com.company.common.ConfigurationLoader;
import com.company.common.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class HRService {


    public boolean onboardEmployee(String employeeName, String departmentName) {

        if (employeeName == null || employeeName.trim().isEmpty()) {
            return false;
        }

        // Load properties from config.properties file
        ConfigurationLoader configLoader = new ConfigurationLoader();
        Properties properties = configLoader.loadPropertiesFile("config.properties");

        String query = "INSERT INTO employee (name, department) VALUES (?, ?)";
        try (Connection connection = Utility.getConnection(properties);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employeeName);
            statement.setString(2, departmentName);

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Employee onboarded: " + employeeName);
                return true;
            } else {
                System.out.println("Failed to onboard employee: " + employeeName);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}