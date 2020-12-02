package infrastructure.pages.pagefactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageFactory extends AbstractPageFactory{

    @FindBy(xpath = "//section[@id='meta-3']//li[1]/a")
    private WebElement loginTitle;

    @FindBy(xpath = "//li[@id = 'menu-item-26']/a")
    private WebElement blogTitle;

    public MainPageFactory(WebDriver driver) {
        super(driver);
    }


    public MainPageFactory openPage(String url){
        driver.get(url);
        return this;
    }

    public LoginPageFactory goToLoginPage(){
        action.click(loginTitle);
        return new LoginPageFactory(driver);
    }

    public BlogPageFactory goToBlogPage(){
        action.click(blogTitle);
        return new BlogPageFactory(driver);
    }

}

