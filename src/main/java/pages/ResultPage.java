package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;

public class ResultPage {
    @FindBy(xpath = " //div[@class='organic bno']//b[text()='Яндекс']")
    WebElement result;

    public ResultPage() throws Exception {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public void selectResult(){
        result.click();
        ArrayList tabs2 = new ArrayList (BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(1).toString());

    }
}
