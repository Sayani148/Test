package tests;

import Base.BaseTest;
import Pages.ProductPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;



public class SearchTest extends BaseTest {

    @Test

    public void verifyDelllaptopAddToCart() throws InterruptedException{

        SearchPage search= new SearchPage(driver);

        search.searchProduct("laptop");
        search.filterDellbrand();
        search.clickDellLaptop();
        String parentwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window:allWindows) {
            if (!window.equals(parentwindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Thread.sleep(2000);



        ProductPage product= new ProductPage(driver);

        String title=product.getProductTitle();
        System.out.println("product Title:"+title);

        Assert.assertTrue(title.contains("Dell"));

        product.clickAddToCart();
    }
}
