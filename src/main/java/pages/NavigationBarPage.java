package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage{
    private By products = By.xpath("//a[@href=\"/products\"]");
    private By cart = By.xpath("//a[@href=\"/view_cart\"]");
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