package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    static WebDriver driver;
    static WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public static WebElement locateElement(By elementLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElement(elementLocator);
    }
    public List<WebElement> locateListOfElement(By elementsLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementsLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementsLocator));
        return driver.findElements(elementsLocator);
    }
    public List<WebElement> locateListElements(By elementLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElements(elementLocator);
    }

    public void clickElement (By elementLocator)
    {
        locateElement(elementLocator).click();
    }

    public void typeOnInputField (By elementLocator, String text)
    {
        locateElement(elementLocator).sendKeys(text);
    }

    public static String getTextOfElement(By elementLocator)
    {
        return locateElement(elementLocator).getText();
    }
    public void scrollingProductsPageV(int y_pixel)
    {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,y_pixel).perform();
    }
    public void hoverOverElement (By elementLocator)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(locateElement(elementLocator)).perform();
    }
    public void forceClickOnElement (By elementLocator)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = locateElement(elementLocator);
        js.executeScript("arguments[0].click()", element);
    }
}
