package org.example.steps;

import io.cucumber.java.en.*;
import org.example.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import org.example.page.methods.FlipkartLoginPageActions;

public class FlipkartLoginSteps {


    public DriverManager test;

    public FlipkartLoginSteps(DriverManager test) throws Exception {
        this.test = test;
    }

    @Given("User launches the Flipkart application")
    public void user_launches_flipkart_application() throws IOException {
        test.launchApplication();
    }

    @Given("User is on the Flipkart home page")
    public void user_is_on_flipkart_home_page() {
        test.Login.verifyFlipkartHomePage();
    }

    @When("User clicks on the login button")
    public void user_clicks_on_login_button() {
        test.Login.clickLoginButton();
    }

    @Then("User should see the login modal or page")
    public void user_should_see_login_modal() {
        test.Login.verifyLoginModalVisible();
    }

    @When("User enters valid email address")
    public void user_enters_valid_email_address() {
        test.Login.enterValidEmail();
    }

    @When("User enters valid password")
    public void user_enters_valid_password() {
        test.Login.enterValidPassword();
    }

    @When("User clicks the submit button")
    public void user_clicks_submit_button() {
        test.Login.clickSubmitButton();
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

