package org.example.page.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartLoginPage {

    public WebDriver driver;

    public FlipkartLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@href='/']")
    public WebElement flipkartLogo;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@type='text' and @placeholder='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Login') or contains(text(), 'Continue')]")
    public WebElement submitButton;

    @FindBy(xpath = "//a[@href='#profile']")
    public WebElement userProfile;


}

