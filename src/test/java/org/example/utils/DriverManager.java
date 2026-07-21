package org.example.utils;

import org.example.page.methods.LoginPageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


import static org.example.utils.YamlReader.getDataFromYaml;
import static org.example.utils.YamlReader.setYamlFilePath;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;


public class DriverManager {
   public WebDriver driver;
   Properties properties;
   private  SoftAssert softAssert;

   public LoginPageActions Login;

   public DriverManager() {
       try{
           LoggerUtil.info("------Test Execution Started------");
           setup();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

   public WebDriver getChromeDriver() {
       if (driver == null) {
           driver = new ChromeDriver();
       }
       return driver;
   }

   public WebDriver getFirefoxDriver() {
       if (driver == null) {
           driver = new FirefoxDriver();
       }
       return driver;
   }
   public void setupDriver() throws IOException {
       properties = new Properties();
       InputStream propStream = new FileInputStream("src"+ File.separator+"test"+File.separator+"resources"+File.separator+"configuration"+File.separator+"config.properties");
       try {
           properties.load(propStream);
       } catch (IOException e) {
           throw new IOException("Could not find config.properties in classpath or " + propStream);
       }
        String browser = System.getProperty("browser", "chrome");
       if (browser.equalsIgnoreCase("chrome")) {
           driver = getChromeDriver();
           LoggerUtil.info("Chrome browser is launched");
       } else if (browser.equalsIgnoreCase("firefox")) {
           driver = getFirefoxDriver();
           LoggerUtil.info("Firefox browser is launched");
       } else {
           throw new IllegalArgumentException("Unsupported browser: " + browser);
       }
   }

   public String getUrl() throws IOException {
         String url = null;
         try{
             url = System.getProperty("url");
             LoggerUtil.info("URL from system property: " + url);
             if (url == null || url.isEmpty()) {
                 url = getDataFromYaml("url");
                    LoggerUtil.info("URL from YAML: " + url);
             }
         } catch (Exception e) {
             LoggerUtil.error("Error occurred while fetching URL: " + e.getMessage());
             e.printStackTrace();
         }
         return url;
   }

   public void intializeAllPages(){
       Login = PageFactory.initElements(driver, LoginPageActions.class);
   }

   public void setup() throws IOException {
       setupDriver();
       setYamlFilePath();
       getUrl();
       intializeAllPages();
   }
    public void launchApplication() throws IOException {
         String url = getUrl();
         if (driver == null) {
             throw new IllegalStateException("WebDriver is not initialized. Call setupDriver() or setup() first.");
         }
         if (url == null || url.isEmpty()) {
             throw new IllegalStateException("URL is null or empty. Check config or YAML for 'url'");
         }
         driver.get(url);
         driver.manage().window().maximize();
         intializeAllPages();
    }

    public void setupSoftAssert(SoftAssert softAssert) {
        this.softAssert = new SoftAssert();
    }

    public SoftAssert getSoftAssert() {
       return softAssert;
    }

}

