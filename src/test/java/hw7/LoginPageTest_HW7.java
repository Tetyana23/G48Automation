package hw7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import tests.BaseTest;

public class LoginPageTest_HW7 extends BaseTest {
    private final static Logger LOG = LogManager.getLogger("Version");

    private LoginPage loginPage;
    private FirstPage_hw7 gitHubFirstPage;
    private PomePage pomePage;
    private SearchPage searchPage;

    @Before
    public void setUp() {
        loginPage = new LoginPage(driver);
        gitHubFirstPage = new FirstPage_hw7(driver);
        pomePage = new PomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @Test
    public void checkLogin() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
    }

    @Test
    public void checkVersion() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        searchPage.openProject("Tetyana23");
        String version = pomePage.findVersion("selenium-java");
        LOG.info(version);
        Assert.assertEquals("3.141.59", version);
    }

    @Test
    public void checkTab(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        searchPage.openProject("Tetyana23");
        gitHubFirstPage.printTabs();

    }


}




