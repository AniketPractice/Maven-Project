package com.company.app;

import com.company.common.ConfigurationLoader;
import com.company.common.Utility;
import com.company.finance.FinanceService;
import com.company.hr.HRService;
import com.company.it.ITService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.Properties;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        // Load database configuration from properties file
        ConfigurationLoader configLoader = new ConfigurationLoader();

        Properties dbProperties = configLoader.loadPropertiesFile("config.properties");

        if (dbProperties.isEmpty()) {
            logger.error("Failed to load database properties. Exiting...");
            return;
        }

        // Process payroll
        FinanceService financeService = new FinanceService();
        boolean payroll = financeService.processPayroll("Aniket Khedekar", 50000);

        if (payroll) {
            logger.info("Payroll processed successfully.");
        } else {
            logger.error("Failed to process payroll.");
        }

        HRService hrService = new HRService();
        boolean boarding = hrService.onboardEmployee("Aniket", "CP 2");

        if (boarding) {
            logger.info("Employee onboarded successfully.");
        } else {
            logger.error("Failed to onboard employee.");
        }

        ITService itService = new ITService();
        boolean access = itService.giveAccess("Aniket");

        if (access) {
            logger.info("Access provided to the employee.");
        } else {
            logger.error("Failed to provide access.");
        }

        // Set database properties in Utility
        String url = dbProperties.getProperty("database.url");
        String username = dbProperties.getProperty("database.username");
        String password = dbProperties.getProperty("database.password");

        if (url == null || username == null || password == null) {
            logger.error("Missing database properties in db.properties file. Exiting...");
            return;
        }

        // Establish connection to the database
        Connection connection = Utility.getConnection(dbProperties);
        if (connection != null) {
            logger.info("Database connection established successfully!");
        } else {
            logger.error("Failed to establish database connection.");
        }
    }
}
