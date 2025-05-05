# P2U Mobile Automation Test

## Overview

The `p2u_mobille_automation_test` project is an automated testing framework for the **p2u Wallet** Android application. The framework is designed to execute various test scenarios using **Appium** for mobile automation and follows the **Page Object Model** architecture pattern. The project is written in **Java** and utilizes **TestNG** for test execution. **Git** is used for version control to manage the project source code.

## Language & Tools

- **Language**: Java
- **Automation Tool**: Appium
- **Architecture Pattern**: Page Object Model (POM)
- **Version Control**: Git

## Project Structure

```plaintext
src
└── test
    └── java
        └── com.p2u
            ├── pageObjects
            │   ├── CommonPage.java
            │   ├── HomePage.java
            │   ├── InquiryPage.java 
            │   ├── LoginPage.java
            │   ├── SettingsPage.java
            │   ├── SplashScreenPage.java
            │   └── StoresPage.java
            ├── testData
            │   ├── InquiryTestData.java 
            │   ├── LoginTestData.java
            │   ├── StoresTestData.java
            ├── tests
            │   ├── BaseTest.java
            │   ├── LoginTest.java
            │   ├── StoresTest.java
            │   └── InquiryTest.java
            └── utils
                ├── DriverManager.java
                └── GestureSplash.java
testng.xml
pom.xml
README.md
```

### Directory Breakdown:

- **`src/test/java/com.p2u/`**: Main directory containing test scripts and Page Object Model classes.

    - **`pageObjects/`**: Contains the Page Object classes representing different screens and components of the p2uWallet app.
        - `CommonPage.java`: Represents common elements and methods for navigating pages.
        - `HomePage.java`: Represents the home screen of the app.
        - `LoginPage.java`: Represents the login page of the app.
        - `InquiryPage.java`: Represents the inquiry page of the app.
        - `SettingsPage.java`: Represents the settings page of the app.
        - `StoresPage.java`: Represents the page for adding P2U stores.
        - `SplashScreenPage.java`: Represents the splash screen of the app.

    - **`testData/`**: Contains the test data classes used for parameterized testing.
        - `StoresTestData.java`: Contains test data for the "Add P2U Stores" functionality.
        - `LoginTestData.java`: Contains test data for login functionality.
        - `InquiryTestData.java`: Contains test data for inquiry functionality.

    - **`tests/`**: Contains the actual test cases.
        - `BaseTest.java`: Base class for test setup and teardown.
        - `LoginTest.java`: Contains login-related test cases.
        - `StoresTest.java`: Contains test cases related to adding P2U stores.
        - `InquiryTest.java`: Contains test cases for inquiries.

    - **`utils/`**: Contains utility classes.
        - `DriverManager.java`: Manages the Appium driver and session setup.
        - `GestureSplash.java`: Handles gesture-based interactions and splash screen handling.

- **`testng.xml`**: The TestNG configuration file to define test suites and execution.
- **`pom.xml`**: The Maven configuration file for dependency management and build configuration.
- **`README.md`**: Project documentation file.

## Requirements

- **Java** (JDK 22.0.1 or above)
- **Maven** for build automation
- **Appium** )for mobile test automation - Version 2.15.0) 
- **TestNG** for running test cases
- **Android Emulator** or a physical Android device for testing
- **Git** for version control

## Setup and Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/shary0300/p2uWallet-androidAutomationTest.git
   cd p2uWallet-androidAutomationTest
   ```

2. **Install dependencies:**

   Make sure you have Maven installed. Then, run the following command to download all required dependencies:

   ```bash
   mvn clean install
   ```

3. **Configure Appium and Android:**

    - Install [Appium](http://appium.io/) and start the Appium server.
    - Ensure that Android SDK is installed and an emulator is running or a physical device is connected.

4. **Run Tests:**

   You can run the tests using TestNG with the following command:

   ```bash
   mvn test
   ```

   Alternatively, you can execute tests directly from the IDE if it supports Maven and TestNG.

5. **Update `testng.xml`**: Modify `testng.xml` to configure which tests to run, based on the desired suite or group.

## How to Contribute

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to your fork (`git push origin feature-branch`).
5. Create a pull request.

## Tests

Test cases are organized based on the functionality they test. Each test class corresponds to a particular feature in the p2uWallet app.

- **LoginTest.java**: Validates login functionality.
- **AddP2UStoresTest.java**: Validates the ability to add P2U stores.
- **InquiryTest.java**: Validates the inquiry functionality.

Each test case uses the Page Object Model pattern to interact with the app, making the tests more maintainable and readable.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Appium](http://appium.io/) for mobile automation.
- [TestNG](https://testng.org/) for test execution.
- [Maven](https://maven.apache.org/) for build management.
