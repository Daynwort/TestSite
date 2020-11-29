package infrastructure.wdm.capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCapabilities {

    public static Capabilities chromeCapabilities(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("version", "87");
        chromeOptions.setCapability("platform", "win10");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(chromeOptions);
        return new DesiredCapabilities();
    }

    public static Capabilities firefoxCapabilities(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("version", "42");
        firefoxOptions.setCapability("platform", "win7");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.merge(firefoxOptions);
        return new DesiredCapabilities();
    }
}
