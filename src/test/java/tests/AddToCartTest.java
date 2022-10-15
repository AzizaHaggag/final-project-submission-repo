package tests;

import pages.CartPage;
import pages.NavigationBarPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    NavigationBarPage navigationBarPage;
    CartPage cartPage;

    @Test
    public void testAddItemsToCart() //Au_Cart_TC_002
    {
        navigationBarPage = new NavigationBarPage(driver);
        ProductsPage productsPage = navigationBarPage.clickProductsFromNavBar();
        productsPage.scrollFirstProduct();
        productsPage.addFirstProductToCart();

        CartPage cartPage = productsPage.clickViewCartBtn();
        Assert.assertEquals(cartPage.getNumberOfAddedItems(), 1,
                "The Number added items should be 1");
        Assert.assertEquals(cartPage.getPriceOfFirstProduct(), "Rs. 500",
                "The Price should be Rs. 500");
        Assert.assertEquals(cartPage.getQuantityOfFirstProduct(), "1",
                "The quantity should be 1");
        Assert.assertEquals(cartPage.getCartTotalOfFirstProduct(), "Rs. 500",
                "The Total price of first product should be Rs. 500");
    }

    @Test
    public void testAddMultipleItemsToCart() //Au_Cart_TC_003
    {
        navigationBarPage = new NavigationBarPage(driver);
        ProductsPage productsPage = navigationBarPage.clickProductsFromNavBar();
        productsPage.scrollFirstProduct();
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShoppingBtn();
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShoppingBtn();
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShoppingBtn();
        productsPage.addFirstProductToCart();
        productsPage.clickContinueShoppingBtn();
        productsPage.addFirstProductToCart();

        cartPage = productsPage.clickViewCartBtn();

        Assert.assertEquals(cartPage.getPriceOfFirstProduct(), "Rs. 500",
                "The Price should be Rs. 500");
        Assert.assertEquals(cartPage.getQuantityOfFirstProduct(), "5",
                "The quantity should be 5");
        Assert.assertEquals(cartPage.getCartTotalOfFirstProduct(), "Rs. 2500",
                "The Total price of first product should be Rs. 2500");
    }
}

