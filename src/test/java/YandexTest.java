import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutorizationPage;
import pages.MainPage;
import pages.PostPage;
import pages.ResultPage;
import steps.BaseSteps;

public class YandexTest {
    private static String result;

    @BeforeAll
    public static void setUp() throws Exception{
        BaseSteps.setUp();
        MainPage mainPage = new MainPage();
        mainPage.selectMenuItem("Яндекс Почта");

        ResultPage resultPage = new ResultPage();
        resultPage.selectResult();

        PostPage postPage = new PostPage();
        postPage.scrollingDown();
        postPage.clickEnterButton();

        AutorizationPage autorizationPage = new AutorizationPage();
        autorizationPage.inputUserName();
        result = autorizationPage.getErrorMessage();
    }
    @Test
    public void test()  {
        String errorMessage = "Такой логин не подойдет";
        Assertions.assertEquals(errorMessage, result);
        String res = errorMessage.equals(result) ? "passed" : "failed";
        WriteXMLFile.generateXML(res);
    }
}
