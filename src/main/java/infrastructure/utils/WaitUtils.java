package infrastructure.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WaitUtils {
    WebDriver driver ;
    WebDriverWait wait;
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }


    public  void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilDisplayed(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitUntilSelected(WebElement element){
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public void waitUntilPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

}
