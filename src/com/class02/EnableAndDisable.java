package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class EnableAndDisable {

    WebDriver driver;
    @Test(enabled = false)
    public void firstMethod(){
        System.out.println("This execution should come later");
    }

    @Test(priority = 2,enabled = false)
    public void secondMethod(){
        System.out.println("This execution should come first");
    }

    @Test(priority = 1,enabled = false)
    public void thirdMethod(){
        System.out.println("This execution should come last");
    }

    @BeforeMethod
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void invalidLogin(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement errorField = driver.findElement(By.id("spanMessage"));

        String receivingText = errorField.getText();
        String actualText = "Password cannot be empty";

        Assert.assertEquals(receivingText,actualText);
        System.out.println("Test is passed");

        /*if (receivingText.equals(actualText)){
            System.out.println("Test is passed and error is displayed");
        }else {
            System.out.println("Test is failed and error is not available");
        }*/
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

