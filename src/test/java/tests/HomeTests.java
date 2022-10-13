package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTests extends BaseTest {
    @Test
    public void testHomeItemsAreVisibile() {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.category(), "CATEGORY", "The text should be CATEGORY");
    }
}
