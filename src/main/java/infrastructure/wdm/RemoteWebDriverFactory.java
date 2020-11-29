package infrastructure.wdm;

import infrastructure.ConfigurationManager;
import infrastructure.wdm.capabilities.BrowserCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverFactory  implements WebDriverFactory {
    DesiredCapabilities caps = new DesiredCapabilities();
    WebDriver driver;

    @Override
    public WebDriver create() {
        BrowserType testBrowser = ConfigurationManager.getInstance().getTestBrowser();
        switch (testBrowser) {
            case CHROME:
                caps.merge(BrowserCapabilities.chromeCapabilities());
                break;
            case FIREFOX:
                caps.merge(BrowserCapabilities.firefoxCapabilities());
                break;
            default:
                throw new IllegalArgumentException(String.format("Unable to create driver with this type %s", testBrowser));
        }
                try {
                    driver =  new RemoteWebDriver(new URL(ConfigurationManager.getInstance().getRemoteHubUrl()), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return driver;

    }
    }

