package com.company.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationLoader{

    public Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();

        // Load the properties file using the class loader
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            if (resourceAsStream == null) {
                System.err.println("Unable to find properties file: " + filePath);
                return prop;  // Return empty properties if not found
            }
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file: " + filePath);
        }

        return prop;
    }

}
