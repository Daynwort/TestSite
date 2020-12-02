package infrastructure.pages.pagefactory;

import infrastructure.wdm.ActionManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageFactory {
    WebDriver driver;
    ActionManager action;

    public AbstractPageFactory (WebDriver driver) {
        this.driver = driver;
        this.action = new ActionManager(driver);
        PageFactory.initElements(driver, this);
    }

}
