package com.class03;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hw {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void openBrowserAndLaunchApp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /*@AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }*/

    @Test()
    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider
    public Object[][] employeeData(){
        Object[][] data = {
                {"Tom", "Sheppard", "tomshep", "P@ss1Weaklets!", "P@ss1Weaklets!"},
        };
        return data;
    }
    @Test(dataProvider = "employeeData",groups = "createEmployee")
    public void addEmployee(String firstName, String lastName, String userName, String password, String confirmPassword){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        login();
        WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
        Actions actions = new Actions(driver);
        actions.moveToElement(PIM).perform();
        WebElement addEmployeeLink = driver.findElement(By.linkText("Add Employee"));
        addEmployeeLink.click();

        WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
        firstNameTextBox.sendKeys(firstName);
        WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        lastNameTextBox.sendKeys(lastName);
        WebElement checkBox = driver.findElement(By.id("chkLogin"));
        checkBox.click();
        WebElement userNameTextBox = driver.findElement(By.id("user_name"));
        userNameTextBox.sendKeys(userName);
        WebElement passwordTextBox = driver.findElement(By.id("user_password"));
        passwordTextBox.sendKeys(password);
        WebElement confrimPassTextBox = driver.findElement(By.id("re_password"));
        confrimPassTextBox.sendKeys(confirmPassword);
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        saveButton.click();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text() = 'Full Name']")));
        /*TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFIle = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFIle, new File("screenshots/HRMS/addedEmployee"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
