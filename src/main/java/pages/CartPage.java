package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By itemsInTheCart = By.xpath("//tr[contains(@id,\"product-\")]");
    private By priceOfFirstProduct = By.cssSelector("#product-1>.cart_price");
    private By quantityOfFirstProduct = By.cssSelector("#product-1> .cart_quantity");
    private By cartTotalOfFirstProduct = By.cssSelector("#product-1> .cart_total");

    public int getNumberOfAddedItems()
    {
        List<WebElement> productsInTheCart = locateListOfElement(itemsInTheCart);
        return productsInTheCart.size();
    }
    public String getPriceOfFirstProduct()
    {
        return getTextOfElement(priceOfFirstProduct);
    }
    public String getQuantityOfFirstProduct()
    {
        return getTextOfElement(quantityOfFirstProduct);
    }
    public String getCartTotalOfFirstProduct()
    {
        return getTextOfElement(cartTotalOfFirstProduct);
    }


}

