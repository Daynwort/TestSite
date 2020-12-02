package infrastructure.pages.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPageFactory extends AbstractPageFactory{
    String commentText;

    @FindBy(xpath = "//div[@id='comments']/ol")
    private WebElement commentsList;

    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement commentField;

    @FindBy(xpath = "//input[@id='submit']")
    private WebElement postCommentButton;

    public PostPageFactory(WebDriver driver) {
        super(driver);
    }

    public PostPageFactory typeComment(String comment){
        action.typeText(comment, commentField);
        return this;
    }

    public PostPageFactory clickPostCommentButton(){
        action.click(postCommentButton);
        return this;
    }

    public String findPostedText(){
        return action.getText(commentsList);
    }
}
