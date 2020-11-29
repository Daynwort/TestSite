package infrastructure.wdm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ActionManager {
    WebDriver driver;

    public ActionManager(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element){
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException e){
            throw new RuntimeException(element + " is not found");
        }
    }

    public void typeText(String input, By intoElement){
        try {
            driver.findElement(intoElement).clear();
            driver.findElement(intoElement).sendKeys(input);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void scrollTo(By element){
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
}
