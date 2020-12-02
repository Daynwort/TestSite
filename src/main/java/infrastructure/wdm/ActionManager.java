package infrastructure.wdm;

import infrastructure.utils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionManager {
    WebDriver driver;
    WaitUtils wait;

    public ActionManager(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public void click(WebElement element){
        try {
            wait.waitUntilClickable(element);
            element.click();
        } catch (NoSuchElementException e){
            throw new RuntimeException(element + " is not found");
        }
    }

    public void typeText(String input, WebElement intoElement){
        try {
            wait.waitUntilDisplayed(intoElement);
            intoElement.clear();
            intoElement.sendKeys(input);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public void scrollTo(WebElement element){
        try {
            wait.waitUntilDisplayed(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public String getText(WebElement element){
        String text = "";
        try {
            wait.waitUntilDisplayed(element);
             text = element.getText();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return text;
    }
}
