package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.concurrent.TimeUnit;

public class ParallelTest extends CommonMethods {

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

}
