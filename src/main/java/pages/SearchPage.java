package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{
    private By searchField = By.id("search_product");
    private By searchBtn = By.cssSelector(".container > button");
    private By searchedProducts = By.cssSelector(".features_items > h2");
    private By modalContent = By.xpath("//div[@class=\"productinfo text-center\"]//p[contains(text(),'Top')]");
    private By firstProduct = By.xpath("(//div[@class=\"productinfo text-center\"])[1]");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage productSearch(String searchTextBox)
    {
        typeOnInputField(searchField,searchTextBox);
        clickElement(searchBtn);
        return new ProductsPage(driver);
    }
    public String searchedProducts()
    {
        return getTextOfElement (searchedProducts);
    }

    public int getModalContent()
    {
        List<WebElement> modalContentItems = locateListElements(modalContent);
        return modalContentItems.size();
    }

}
