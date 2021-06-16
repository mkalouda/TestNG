package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionDemo2 {

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
    public void loginAndValidateTitle(){
        String expectedTitle = "Human Management System";
        String actualTitle = driver.getTitle();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedTitle,actualTitle);

        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        WebElement welcomeText = driver.findElement(By.linkText("Welcome Admin"));
        String receivedValue = welcomeText.getText();
        String existedValue = "edfs";
        softAssert.assertEquals(receivedValue,existedValue);
        System.out.println("My test case is not working according to the user story");

        softAssert.assertAll();
    }
}
