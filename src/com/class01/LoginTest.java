package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void validLogin(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        WebElement welcomeText = driver.findElement(By.linkText("Welcome Admin"));
        if (welcomeText.isDisplayed()){
            System.out.println("Test is valid and Passed");
        }else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void validationOfTitle(){
        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test is final and Title is same");
        }else {
            System.out.println("Test failed");
        }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
