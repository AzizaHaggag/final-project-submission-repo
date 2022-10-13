package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By Category = By.cssSelector(".left-sidebar >h2");
    private By logedinas = By.xpath("//i[@class=\"fa fa-user\"]");
    public HomePage (WebDriver driver)
    {
        super(driver);
    }
    public String category ()
    {
        return getTextOfElement (Category);
    }


}
