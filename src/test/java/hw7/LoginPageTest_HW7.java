package hw7;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@Feature("Positive autorization. Moving to project. Searching the library version and Logging it to Console. Printing the Project Tabs")
@Story("HW7")
@Owner("Tetyana23")
@Severity(SeverityLevel.NORMAL)
public class LoginPageTest_HW7 extends BaseTest {
    private final static Logger LOG = LogManager.getLogger("Version");

    private LoginPageObject loginPage;
    private FirstPage_hw7 gitHubFirstPage;
    private PomePage pomePage;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver);
        gitHubFirstPage = new FirstPage_hw7(driver);
        pomePage = new PomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Description("Positive Autorization")
    @Test
    public void checkLogin() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
    }

    @Description("Тест нужен, чтобы перейти в проект. Также, чтобы найти версию библиотеки selenium-java и залогировать ее в консоль")
    @Test
    public void checkVersion() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        searchPage.openProject("Tetyana23");
        String version = pomePage.findVersion("selenium-java");
        LOG.info(version);
        Assert.assertEquals("3.141.59", version);
    }

    @Description("Тест нужен, чтобы напечатать название всех вкладок страницы проекта")
    @Test
    public void checkTab(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        searchPage.openProject("Tetyana23");
        gitHubFirstPage.printTabs();

    }


}




