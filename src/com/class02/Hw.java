package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class Hw {

    WebDriver driver;

    @BeforeMethod
    public void openBrowserAndLogin() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Test
    public void addEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SoftAssert soft = new SoftAssert();

        WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        Actions actions = new Actions(driver);
        actions.moveToElement(PIM).perform();
        WebElement addEmployeeLink = driver.findElement(By.linkText("Add Employee"));
        addEmployeeLink.click();

        WebElement fullNameLabel = driver.findElement(By.className("hasTopFieldHelp"));
        String fullNameTextActual = fullNameLabel.getText();
        String fullNameTextExpected = "Full Name";
        soft.assertEquals(fullNameTextActual,fullNameTextExpected);

        WebElement employeeIDLabel = driver.findElement(By.xpath("//label[@for ='employeeId']"));
        String employeeIdTextActual = employeeIDLabel.getText();
        String employeeIdTextExpected = "Employee Id";
        soft.assertEquals(employeeIdTextActual,employeeIdTextExpected);

        WebElement photographLabel = driver.findElement(By.xpath("//label[@for ='photofile']"));
        String photographTextActual = photographLabel.getText();
        String photographTextExpected = "Photograph";
        soft.assertEquals(photographTextActual,photographTextExpected);

        WebElement firstNameText = driver.findElement(By.id("firstName"));
        firstNameText.sendKeys("Moe");
        WebElement lastNameText = driver.findElement(By.id("lastName"));
        lastNameText.sendKeys("Luda");
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();

        WebElement firstNameVerify = driver.findElement(By.id("personal_txtEmpFirstName"));
        String firstNameVerifyText = firstNameVerify.getText();
        System.out.println(firstNameVerifyText);
        //soft.assertEquals(firstNameVerifyText,"Moe");

        WebElement lastNameVerify = driver.findElement(By.id("personal_txtEmpLastName"));
        String lastNameVerifyText = lastNameVerify.getText();
        System.out.println(lastNameVerifyText);
        //soft.assertEquals(lastNameVerifyText,"Luda");

        soft.assertAll();
    }
}
