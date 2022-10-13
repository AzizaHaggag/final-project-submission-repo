package tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import static FileReaders.FileReaders.getPropertyByKey;


public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get(getPropertyByKey("configData.properties","App_URL"));
    }
    @AfterMethod
    public void a_takeScreenshotUponFailedTests(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e); // handle

            }
        }
    }
    @AfterMethod
    public void z_quitDriver ()
    {
        driver.quit();
    }
}
