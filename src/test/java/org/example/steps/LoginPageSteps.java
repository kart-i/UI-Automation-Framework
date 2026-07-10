package org.example.steps;

import io.cucumber.java.en.*;
import org.example.utils.DriverManager;
import java.io.IOException;

public class LoginPageSteps {


    public DriverManager test;

    public LoginPageSteps(DriverManager test) throws Exception {
        this.test = test;
    }

    @Given("User launches the Saucedemo application")
    public void user_launches_flipkart_application() throws IOException {
        test.launchApplication();
    }

    @When("User clicks on the login button")
    public void user_clicks_on_login_button() {
        test.Login.clickLoginButton();
    }

    @Then("User should see the login modal or page")
    public void user_should_see_login_modal() {
        test.Login.verifyLoginModalVisible();
    }

    @When("User enters valid username")
    public void user_enters_valid_username() {
        test.Login.enterValidUsername();
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {
        test.Login.enterValidPassword();
    }

    @When("User clicks the login button")
    public void user_clicks_login_button() {
        test.Login.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        test.Login.verifyUserLoggedInSuccessfully();
    }

    @Then("User profile should be visible in the header")
    public void user_profile_should_be_visible() {
        test.Login.verifyUserProfileVisible();
    }



}

