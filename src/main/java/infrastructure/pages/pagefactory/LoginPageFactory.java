package infrastructure.pages.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageFactory extends AbstractPageFactory{
    @FindBy(xpath = "//input[@id='user_login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id='user_pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='wp-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='login_error']")
    private WebElement errorField;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }


    public LoginPageFactory typeLogin(String login){
        action.typeText(login, loginField);
        return this;
    }

    public LoginPageFactory typePassword(String password){
        action.typeText(password, passwordField);
        return this;
    }

    @SuppressWarnings("UnusedReturnValue")
    public DashboardPageFactory clickSubmitButton(){
        action.click(submitButton);
        return new DashboardPageFactory(driver);
    }

    public String getErrorMessage(){
        return  action.getText(errorField);
    }
}
