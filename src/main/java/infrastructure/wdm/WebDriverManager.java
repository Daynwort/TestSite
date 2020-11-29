package infrastructure.wdm;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {
    WebDriver getDriver();
    void destroyDriver(WebDriver browser);
}
