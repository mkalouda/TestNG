import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SeleniumHW1 {
   WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
       System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
       driver = new ChromeDriver();
       driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginUsernameOnly(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        SoftAssert soft = new SoftAssert();
        WebElement errorMessagePassword = driver.findElement(By.id("spanMessage"));
        String errorMessagePasswordExpected = "Password cannot be empty";
        String errorMessagePasswordActual = errorMessagePassword.getText();
        soft.assertEquals(errorMessagePasswordActual,errorMessagePasswordExpected);

        soft.assertAll();
    }

    @Test(priority = 2)
    public void loginUserAndPassEmpty(){
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        SoftAssert soft = new SoftAssert();
        WebElement errorMessagePassword = driver.findElement(By.id("spanMessage"));
        String errorMessagePasswordExpected = "Username cannot be empty";
        String errorMessagePasswordActual = errorMessagePassword.getText();
        soft.assertEquals(errorMessagePasswordActual,errorMessagePasswordExpected);

        soft.assertAll();
    }

    @Test(priority = 3)
    public void loginInvalidCredentials(){
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();

        SoftAssert soft = new SoftAssert();
        WebElement errorMessagePassword = driver.findElement(By.id("spanMessage"));
        String errorMessagePasswordExpected = "Invalid credentials";
        String errorMessagePasswordActual = errorMessagePassword.getText();
        soft.assertEquals(errorMessagePasswordActual,errorMessagePasswordExpected);

        soft.assertAll();
    }

}
