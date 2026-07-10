@Login
Feature: Saucedemo Login Automation

  Background:
    Given User launches the Saucedemo application


  Scenario: User successfully logs in with valid credentials
    When User enters valid username
    And User enters valid password
    And User clicks the login button
    Then User should be logged in successfully




