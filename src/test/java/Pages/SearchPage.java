package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;

public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver=driver;

    }

    By searchBox=By.id("twotabsearchtextbox");
    By searchButton=By.id("nav-search-submit-button");
    By dellcheckbox=By.xpath("//span[text()='Dell']");
    By delllaptop = By.xpath(" (//div[@data-component-type='s-search-result' and not(.//span[text()='Sponsored'])]//h2//span)[1]");


    public void searchProduct(String product){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public void filterDellbrand(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(dellcheckbox));
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
       try{
           Thread.sleep(2000);
       }catch(Exception e){

       }

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);

       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-component-type='s-search-result']")));
    }

    public void clickDellLaptop(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(delllaptop));

        driver.findElement(delllaptop).click();

    }

}
