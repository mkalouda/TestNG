package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigReader.readProperties("/Users/mariamosman/IdeaProjects/TestNG/src/config/config.properties");
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of browser");
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
