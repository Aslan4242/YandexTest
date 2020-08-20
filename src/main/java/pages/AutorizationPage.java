package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class AutorizationPage {
    @FindBy(xpath = "//input[@autocomplete='username']")
    WebElement result;

    @FindBy(xpath ="//div[contains(text(),'Такой логин не')]" )
    WebElement error;

    public AutorizationPage() throws Exception {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void inputUserName(){
        result.click();
        String randomUserName = String.valueOf((int) (Math.random() * 10000));
        result.sendKeys(randomUserName+"\n");
    }

    public String getErrorMessage(){
        String  errorMessage = error.getText();
        return errorMessage;
    }
}
