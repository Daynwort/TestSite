package infrastructure.base;

import infrastructure.ConfigurationManager;
import infrastructure.TestServer;
import infrastructure.logging.AbstractLogger;
import infrastructure.logging.FileTestLogger;
import infrastructure.logging.StdTestLogger;
import infrastructure.utils.WaitUtils;
import infrastructure.wdm.DefaultWebDriverManager;
import infrastructure.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class TestBase {
    private WebDriverManager wdm;
    protected AbstractLogger logger;
    protected WebDriver driver;
    protected WaitUtils wait;
    private TestServer server;

    @Before
    public void setup(){
        wdm = new DefaultWebDriverManager();
        logger = getLogger();
        server = new TestServer();
        String url = server.getUrl();
        logger.log(url);
        driver = wdm.getDriver();
        wait = new WaitUtils(driver);
        beforeTest();
    }
    @After
    public void teardown(){
        wdm.destroyDriver(driver);
        afterTest();
    }

    public void beforeTest(){

    }

    public AbstractLogger getLogger(){
       return ConfigurationManager.getInstance().getCurrentEnvironment().equals("local") ?
                new StdTestLogger() : new FileTestLogger();
    }

    public void afterTest(){
        logger.atFinish();
    }

}
