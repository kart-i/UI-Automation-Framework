Feature: Flipkart Login Automation

  Background:
    Given User launches the Flipkart application
    And User is on the Flipkart home page

  Scenario: User successfully logs in with valid credentials
    When User clicks on the login button
    Then User should see the login modal or page
    When User enters valid email address
    And User enters valid password
    And User clicks the submit button
    Then User should be logged in successfully
    And User profile should be visible in the header



