# Maven Project
This is a Maven-based multi-module project that simulates various functionalities for a company. The project is structured into multiple modules representing different departments within the company: Finance, HR, IT, and a Common module for shared utilities. Additionally, there is an App module that integrates all of these modules and processes different tasks such as payroll processing, employee onboarding, and IT access management.

# Project Overview
The project is organized into the following modules:

Common Module: Provides shared utilities, such as database connection management, that are used by the other modules.
HR Module: Manages employee onboarding tasks, including inserting employee details into the database.
Finance Module: Handles payroll processing, including storing employee salary information.
IT Module: Manages IT access requests for employees, granting IT access as needed.
App Module: The main module that integrates all other modules and acts as the entry point to the application.
Key Features of the Project
1. Common Module
   Contains utility classes that are shared across other modules, such as database connection management.
   Responsible for reading environment-specific database properties and providing a connection to the database.
2. HR Module
   Handles employee onboarding processes.
   Allows for adding employees to the database by providing essential information like employee name, department, etc.
3. Finance Module
   Manages payroll processing.
   Stores salary information for employees in the database.
4. IT Module
   Manages IT access requests for employees.
   Grants IT access when an employee is onboarded.
5. App Module
   Integrates the functionality of all the modules.
   Serves as the main application where operations like employee onboarding, payroll processing, and IT access management take place.
   Project Build and Configuration
   The project uses Maven for dependency management, build configuration, and project structure.

# Maven Profiles
The project uses Maven profiles to configure settings specific to each environment (Dev, Test, and Prod). These profiles allow the application to connect to different databases or use different configurations depending on the environment.

Dev Profile: Used for development environment configuration.
Test Profile: Used for the testing environment configuration.
Prod Profile: Used for production environment configuration.
You can build the project for a specific environment by specifying the profile in the Maven command:

For development: mvn clean install -Pdev
For testing: mvn clean install -Ptest
For production: mvn clean install -Pprod
# Dependencies
The project utilizes several dependencies to provide necessary functionality across the different modules. These dependencies are managed through Maven and are specified in the pom.xml file.

# Common Dependencies
MySQL Connector: This dependency enables connectivity between the project and MySQL databases. It is used for database operations such as reading and writing data related to employee records, payroll information, etc.

JUnit: This is used for unit testing in the project. JUnit provides a framework for writing and running tests to ensure that each module functions correctly.

Maven Compiler Plugin: This plugin is responsible for compiling the Java source code. It ensures that the project is compiled with the appropriate Java version as per the configuration.

Maven Assembly Plugin: This plugin is used for packaging the application into a single executable JAR file, which includes all necessary dependencies. This allows the project to be run as a standalone application.

These dependencies are declared in the pom.xml files, both at the parent level (for common dependencies) and at the module level (for module-specific dependencies). Maven resolves and downloads the necessary libraries during the build process.

# Packaging
Once the project is built, it can be packaged into a single executable JAR file using the Maven Assembly Plugin. The JAR file includes all the dependencies required to run the project. This JAR can be executed using a simple command in the terminal to start the application.

# Testing
The project includes unit tests to ensure that the functionality in each module works correctly. The tests are written using the JUnit framework. Each module has its own set of tests, validating different functionalities within that module.

# Key Test Cases
HR Module Tests: The tests for the HR module ensure that employee data is correctly added to the database and that employee onboarding tasks are completed in the correct order. These tests also validate that the HR module interacts correctly with the database.

Finance Module Tests: The tests for the Finance module check the correctness of payroll calculations, including verifying that salary information is correctly stored and processed for each employee.

IT Module Tests: The IT module tests ensure that employees are granted IT access as needed. These tests also validate that IT access requests are handled properly and that access can be revoked when necessary.

# Test Coverage
Each module has a dedicated set of tests that cover various scenarios, including both common and edge cases. The tests ensure that the application behaves as expected under different conditions, such as when employees have edge-case data or when certain system conditions change.


