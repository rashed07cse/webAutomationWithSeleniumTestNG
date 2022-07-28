package com.academy.learning.sqa.testngautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginWithoutTestNG {
    /*steps
    1. launch firefox Browser
    2. Launch application
    3. On Login page, input valid userName
    4. On Login page, input  valid password
    5. Click on Login button
    6. Observe application logged in successfully
    7. On Home page, verify page title
     */

    WebDriver driver;

    public static void main(String[] args) {

        LoginWithoutTestNG loginWithoutTestNG = new LoginWithoutTestNG();
        loginWithoutTestNG.setUp();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
        WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
        String actualHomePageTitle = driver.getTitle();
        System.out.println("Application login successfully");
        System.out.println("Home Page Title is: " + actualHomePageTitle);
        try {
            if (actualHomePageTitle.equals("OrangeHRM")) {
                System.out.println("Home Page Title found, Test Case passed");
            }
        } catch (Exception e) {
            System.out.println("Home Page Title: " + actualHomePageTitle + "Not found");
        }
        driver.quit();
    }

    public void setUp() {
        String homeDirectory = System.getProperty("user.dir");
//      System.out.println("home Directory is: " + " " + homeDirectory);
        String driverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverLocation);
    }
}
