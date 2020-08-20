package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;


public class MainPage {
    @FindBy(xpath = "//input[contains(@class, 'input__control input__input mini-suggest__input')]")
    WebElement mainMenu;

    public MainPage() throws Exception {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMenuItem(String phrase) {

        //mainMenu.findElement(By.xpath("//a[text()='Маркет']")).click();
        mainMenu.click();
        mainMenu.sendKeys(phrase+"\n");

    }
}
