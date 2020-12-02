package infrastructure.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPageFactory extends AbstractPageFactory {

    @FindBy(xpath = "//input[@id = 'search-form-1']")
    private WebElement searchForm;

    @FindBy(xpath = "//section[@id = 'search-3']//button")
    private WebElement searchButton;

    @FindBy(xpath = "//main[@id='main']//h2/a")
    private WebElement searchResult;

    public BlogPageFactory(WebDriver driver) {
        super(driver);
    }

    public BlogPageFactory typeSearchRequest(String text){
        action.typeText(text, searchForm);
        return this;
    }

    public BlogPageFactory clickSearchButton(){
        action.click(searchButton);
        return this;
    }

    public String getFoundedPostTitle(){
        return action.getText(searchResult);
    }

    public PostPageFactory goToPostPage(){
        action.click(searchResult);
        return new PostPageFactory(driver);
    }


}
