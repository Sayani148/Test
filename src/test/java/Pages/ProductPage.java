package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;


    }

    By productTitle = By.xpath("//span[@id='productTitle']");
    By addToCartbtn = By.id("add-to-cart-button");

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        try {
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addToCartbtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();


            System.out.println("click Add to cart ");
        } catch (Exception e) {
            System.out.println("add to cart not available , trying buy now");

            WebElement buynow = wait.until(ExpectedConditions.elementToBeClickable(By.id("buy-now-button")));

            buynow.click();
        }
    }
}
