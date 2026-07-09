package org.example.page.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {

    public WebDriver driver;

    public LoginPageElements(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/']")
    public WebElement flipkartLogo;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Login') or contains(text(), 'Continue')]")
    public WebElement submitButton;

    @FindBy(xpath = "//a[@href='#profile']")
    public WebElement userProfile;


}

