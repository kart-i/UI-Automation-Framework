package org.example.page.methods;

import org.example.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.example.page.webelements.LoginPageElements;


public class LoginPageActions extends LoginPageElements {
    public WebDriver driver;
    private WebDriverWait wait;


    public LoginPageActions(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLoginModalVisible() {
        return usernameField.isDisplayed();
    }

    public void enterValidUsername() {
        usernameField.clear();
        usernameField.sendKeys("standard_user");
    }

    public void enterValidPassword() {
        passwordField.clear();
        passwordField.sendKeys("Test@12345");
    }

    public void clickLoginButton() {
        try{
        wait.until(
            ExpectedConditions.elementToBeClickable(submitButton)
        );
        submitButton.click();
        } catch (Exception e) {
            LoggerUtil.error("Error occurred while clicking submit button: " + e.getMessage());
        }
    }

    public boolean verifyUserLoggedInSuccessfully() {
        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));
        return driver.findElement(By.cssSelector(".title")).isDisplayed();
    }

    public boolean verifyUserProfileVisible() {
        return userProfile.isDisplayed();

    }
}

