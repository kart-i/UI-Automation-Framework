# Flipkart Login Automation Suite

This project contains BDD (Behavior-Driven Development) automation tests for Flipkart login functionality using Selenium, Cucumber, and TestNG.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── org/
│           └── example/
│               └── utils/
│                   └── DriverManager.java
└── test/
    ├── java/
    │   ├── Resources/
    │   │   └── FeaturesFiles.feature
    │   └── org/
    │       └── example/
    │           ├── runners/
    │           │   └── FlipkartTestRunner.java
    │           └── steps/
    │               └── FlipkartLoginSteps.java
    └── resources/
```

## Technologies Used

- **Selenium WebDriver** (v4.28.1) - Web automation framework
- **Cucumber** (v7.34.3) - BDD framework for writing test scenarios
- **TestNG** (v7.7.0) - Testing framework
- **Java** (v17) - Programming language
- **Maven** - Build automation tool

## Feature Files

The `FeaturesFiles.feature` file contains 8 comprehensive test scenarios:

1. **User successfully logs in with valid credentials** - Tests successful login flow
2. **User login with invalid email format** - Tests email validation
3. **User login with incorrect password** - Tests password validation
4. **User login with empty email field** - Tests required email validation
5. **User login with empty password field** - Tests required password validation
6. **User can reset password from login page** - Tests password reset functionality
7. **User can close the login modal** - Tests modal closing functionality
8. **User logout from the application** - Tests logout flow

## Step Definitions

The `FlipkartLoginSteps.java` class implements all the Gherkin steps defined in the feature file with proper Selenium WebDriver interactions.

## Running the Tests

### Prerequisites

1. Install Java 17 or higher
2. Install Maven 3.6 or higher
3. Download ChromeDriver matching your Chrome browser version
4. Add ChromeDriver to your PATH or set the `webdriver.chrome.driver` property

### Build the Project

```bash
cd /Users/karthi/IdeaProjects/AutomationSuite
mvn clean install
```

### Run Tests

**Run all tests:**
```bash
mvn test
```

**Run specific feature:**
```bash
mvn test -Dcucumber.filter.tags="@login"
```

**Run using the test runner:**
```bash
mvn test -Dtest=FlipkartTestRunner
```

## Test Reports

After test execution, you can find the reports at:
- HTML Report: `target/cucumber-reports/report.html`
- JSON Report: `target/cucumber-reports/report.json`
- JUnit Report: `target/cucumber-reports/report.xml`

## Key Classes

### DriverManager.java
Utility class for WebDriver management:
- Initialize ChromeDriver/FirefoxDriver
- Get WebDriver and WebDriverWait instances
- Handle driver cleanup
- Navigate URLs
- Get current URL and page title

### FlipkartLoginSteps.java
Cucumber step definitions implementing all login scenarios:
- Login button interactions
- Form field interactions
- Error message validations
- Modal/popup handling
- Logout functionality

### FlipkartTestRunner.java
Cucumber TestNG runner class:
- Configures feature file location
- Sets up glue code paths
- Configures HTML, JSON, and JUnit report generation

## Test Data

Update the following test data in `FlipkartLoginSteps.java`:
- Valid email: `testuser@gmail.com`
- Valid password: `Test@12345`

## Best Practices

1. **POM (Page Object Model)** - Consider implementing POM for better maintainability
2. **Test Data** - Use external configuration files for test data instead of hardcoding
3. **Explicit Waits** - The project uses explicit waits (10 seconds) instead of implicit waits
4. **Driver Management** - Drivers are properly cleaned up in @After hooks
5. **Reports** - Multiple report formats are generated for better visibility

## Troubleshooting

### Tests not finding elements
- Update XPath selectors in `FlipkartLoginSteps.java` based on current Flipkart UI
- Check if Flipkart website structure has changed
- Use browser developer tools to inspect elements

### WebDriver compatibility issues
- Ensure ChromeDriver version matches your Chrome browser version
- Download from: https://chromedriver.chromium.org/

### Test timeouts
- Increase the timeout value in `DriverManager.java` if tests are timing out
- Change `DEFAULT_TIMEOUT = Duration.ofSeconds(10)` to a higher value

## Future Enhancements

1. Implement Page Object Model (POM) pattern
2. Add more test scenarios (2FA, Social login, etc.)
3. Integrate with CI/CD pipelines
4. Add visual regression testing
5. Implement test data factory patterns
6. Add logging and screenshots on failure

## Contact & Support

For issues or questions, refer to the Cucumber and Selenium documentation:
- Cucumber: https://cucumber.io/docs/cucumber/
- Selenium: https://www.selenium.dev/documentation/

