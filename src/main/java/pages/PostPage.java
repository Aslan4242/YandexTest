package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class PostPage {
    @FindBy (xpath = "//a[@class='button2 button2_size_mail-big button2_theme_mail-grey button2_type_link FooterButtons-Button FooterButtons-Button-Enter']")
    WebElement result;

    public PostPage() throws Exception {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void scrollingDown(){
        JavascriptExecutor jse = (JavascriptExecutor)BaseSteps.getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void clickEnterButton(){
        result.click();
    }

}
