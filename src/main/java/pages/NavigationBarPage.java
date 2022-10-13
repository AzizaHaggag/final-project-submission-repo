package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage{
    private By loginNavBar = By.xpath("//a[@href=\"/login\"]");
    private By products = By.xpath("//a[@href=\"/products\"]");
    public NavigationBarPage (WebDriver driver)
    {
        super(driver);
    }

    public ProductsPage clickProductsFromNavBar()
    {
        clickElement(products);
        return new ProductsPage(driver);
    }

}