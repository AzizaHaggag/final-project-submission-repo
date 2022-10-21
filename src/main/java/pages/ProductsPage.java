package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By searchedProducts = By.cssSelector(".features_items > h2");
    private By allProducts = By.cssSelector(".features_items > h2");
    private By firstProduct = By.xpath("(//div[@class=\"productinfo text-center\"])[1]");
    private By addFirstProductToCart = By.xpath("(//div[@class=\"productinfo text-center\"]/a)[1]");
    private By continueShoppingBtn = By.cssSelector(".btn-success");
    private By viewCartLink = By.xpath("//p[@class=\"text-center\"]/a");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String allProducts() {
        return getTextOfElement(allProducts);
    }

    public void scrollFirstProduct() {
        scrollingProductsPageV(600);
    }

    public void addFirstProductToCart() {
        hoverOverElement(firstProduct);
        forceClickOnElement(addFirstProductToCart);
    }

    public ProductsPage clickContinueShoppingBtn() {
        clickElement(continueShoppingBtn);
        return new ProductsPage(driver);
    }

    public ProductsPage addOneProductMultipleTimes() {

        for (int i = 0; i <= 3; i++) {
            hoverOverElement(firstProduct);
            forceClickOnElement(addFirstProductToCart);
            clickElement(continueShoppingBtn);

        }
        forceClickOnElement(addFirstProductToCart);
        return new ProductsPage(driver);
    }

    public CartPage clickViewCartBtn() {
        clickElement(viewCartLink);
        return new CartPage(driver);
    }
}
