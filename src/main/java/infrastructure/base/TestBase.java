package infrastructure.base;

import infrastructure.ConfigurationManager;
import infrastructure.TestServer;
import infrastructure.logging.AbstractLogger;
import infrastructure.logging.FileTestLogger;
import infrastructure.logging.StdTestLogger;
import infrastructure.wdm.DefaultWebDriverManager;
import infrastructure.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class TestBase {
    private WebDriverManager wdm;
    protected AbstractLogger logger;
    protected WebDriver driver;
    protected TestServer server;

    @Before
    public void beforeTest(){
        wdm = new DefaultWebDriverManager();
        server = new TestServer();
        driver = wdm.getDriver();
        logger = getLogger();
    }
    @After
    public void teardown(){
        wdm.destroyDriver(driver);
        afterTest();
    }

    public AbstractLogger getLogger(){
       return ConfigurationManager.getInstance().getCurrentEnvironment().equals("local") ?
                new StdTestLogger() : new FileTestLogger();
    }

    public void afterTest(){
        logger.atFinish();
    }

}
