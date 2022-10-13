package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.ProductsPage;
import pages.SearchPage;
import static FileReaders.FileReaders.getJsonValueByKey;
public class SearchProductsTest extends BaseTest {
    NavigationBarPage navigationBarPage;
    String productTitle;
    String  productTitle2;
    @BeforeClass
    public void loadTestData ()
    {
        productTitle = (String) getJsonValueByKey("testData.json","productName");
        productTitle2 = (String) getJsonValueByKey("testData.json", "productName2");

    }
    @Test
    public void testUserCanNavigatedAllProductsPage() //Au_Pr_TC_003
    {

        navigationBarPage = new NavigationBarPage(driver);
        ProductsPage productsPage = navigationBarPage.clickProductsFromNavBar();
        Assert.assertEquals(productsPage.allProducts(), "ALL PRODUCTS",
                "The Text should be ALL PRODUCTS");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.productSearch(productTitle);

        Assert.assertEquals(searchPage.searchedProducts(), "SEARCHED PRODUCTS",
                "The Text should be SEARCHED PRODUCTS");

        Assert.assertEquals(searchPage.getModalContent(), 12, "The Text should be contains Top");
    }

    @Test
    public void testUserCanSeeMessageWhenNoResult() //Au_Pr_TC_004
    {

        navigationBarPage = new NavigationBarPage(driver);
        ProductsPage productsPage = navigationBarPage.clickProductsFromNavBar();
        Assert.assertEquals(productsPage.allProducts(), "ALL PRODUCTS",
                "The Text should be ALL PRODUCTS");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.productSearch(productTitle2);
        Assert.assertEquals(searchPage.searchedProducts(), "There is no results related to this search keyword",
                "The Text should be There is no results related to this search keyword");
        }
    }









