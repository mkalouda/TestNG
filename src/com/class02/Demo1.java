package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demo1 {

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
    public void validLogin() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void invalidLogin(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement errorField = driver.findElement(By.id("spanMessage"));

        String receivingText = errorField.getText();
        String actualText = "Password cannot be emp";

        Assert.assertEquals(receivingText,actualText);
        System.out.println("Test is passed");

        /*if (receivingText.equals(actualText)){
            System.out.println("Test is passed and error is displayed");
        }else {
            System.out.println("Test is failed and error is not available");
        }*/
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
