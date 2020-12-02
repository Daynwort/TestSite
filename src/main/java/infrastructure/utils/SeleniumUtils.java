package infrastructure.utils;

import org.openqa.selenium.WebDriver;

public class SeleniumUtils {
    WebDriver driver;
    String parentWindow;


    public SeleniumUtils(WebDriver driver, String parentWindow) {
        this.driver = driver;
        this.parentWindow = parentWindow;
    }


    public SeleniumUtils switchToWindowByTitle(String title){
        for (String window: driver.getWindowHandles()){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)){
                break;
            }
        }
        return this;
    }

    public SeleniumUtils switchToWindowContainsUrl(String url){
        for (String window: driver.getWindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains(url)){
                break;
            }
        }
        return this;
    }

    public SeleniumUtils returnToParentWindow(){
        driver.switchTo().window(parentWindow);
        return this;
    }

    public SeleniumUtils closeExtraWindows(){
        for (String window: driver.getWindowHandles()){
            driver.switchTo().window(window);
            if(!driver.getWindowHandle().equals(parentWindow)){
                driver.close();
            }
        }
        return this;
    }

    public SeleniumUtils acceptPopUp(){
        driver.switchTo().alert().accept();
        return this;
    }

    public SeleniumUtils dismissPopUp(){
        driver.switchTo().alert().dismiss();
        return this;
    }
}
