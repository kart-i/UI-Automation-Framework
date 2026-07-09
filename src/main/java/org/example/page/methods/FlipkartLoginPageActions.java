package org.example.page.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.example.page.webelements.FlipkartLoginPage;


public class FlipkartLoginPageActions extends FlipkartLoginPage {
    public WebDriver driver;
    private WebDriverWait wait;


    public FlipkartLoginPageActions(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean verifyFlipkartHomePage() {
        return flipkartLogo.isDisplayed();

    }

    public void clickLoginButton() {
        wait.until(
            ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginButton.click();
    }

    public boolean verifyLoginModalVisible() {
        return emailField.isDisplayed();
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

    public boolean verifyUserLoggedInSuccessfully() {
        wait.until(ExpectedConditions.urlContains("flipkart.com"));
        return driver.findElements(By.xpath("//a[contains(text(), 'Login')]")).isEmpty();
    }

    public boolean verifyUserProfileVisible() {
        return userProfile.isDisplayed();

    }
}

