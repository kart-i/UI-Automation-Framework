package org.example.page.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.example.page.webelements.FlipkartLoginPage;
import static org.testng.Assert.*;

public class FlipkartLoginPageActions extends FlipkartLoginPage {
    public WebDriver driver;
    private WebDriverWait wait;


    public FlipkartLoginPageActions(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void verifyFlipkartHomePage() {
        flipkartLogo.isDisplayed();
        assertNotNull(flipkartLogo, "Flipkart home page not loaded");
    }

    public void clickLoginButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginButton.click();
    }

    public void verifyLoginModalVisible() {
//        wait.until(
//            ExpectedConditions.presenceOf(emailField));
        assertTrue(emailField.isDisplayed(), "Login form is not visible");
    }

    public void enterValidEmail() {
        emailField.clear();
        emailField.sendKeys("testuser@gmail.com");
    }

    public void enterValidPassword() {
        passwordField.clear();
        passwordField.sendKeys("Test@12345");
    }

    public void clickSubmitButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        );
        submitButton.click();
    }

    public void verifyUserLoggedInSuccessfully() {
        wait.until(ExpectedConditions.urlContains("flipkart.com"));
        boolean loginButtonVisible = driver.findElements(By.xpath("//a[contains(text(), 'Login')]")).isEmpty();
        assertTrue(loginButtonVisible, "User is not logged in");
    }

    public void verifyUserProfileVisible() {
        userProfile.isDisplayed();
        assertTrue(userProfile.isDisplayed(), "User profile is not visible in header");
    }
}

