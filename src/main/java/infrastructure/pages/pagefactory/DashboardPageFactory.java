package infrastructure.pages.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardPageFactory extends AbstractPageFactory{

    @FindBy(xpath = "//li[@id='wp-admin-bar-my-account']/a")
    private WebElement adminBarTextField;

    @FindBy(xpath = "//li[@id = 'wp-admin-bar-site-name']/a")
    private WebElement goHome;

    public DashboardPageFactory(WebDriver driver) {
        super(driver);
    }


    public String getAdminBarText(){
        return action.getText(adminBarTextField);
    }

    public MainPageFactory goToMainPage(){        ;
        action.click(goHome);
        return new MainPageFactory(driver);
    }


}
