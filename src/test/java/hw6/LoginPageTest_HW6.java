package hw6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageObject;
import tests.BaseTest;

public class LoginPageTest_HW6 extends BaseTest {
    private final static Logger LOG = LogManager.getLogger("Version");

    private LoginPageObject loginPage;
    private FirstPage_hw6 gitHubFirstPage;

    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver);
        gitHubFirstPage = new FirstPage_hw6(driver);
    }

    @Test
    public void checkLogin() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        // loginPage.validateErrorMessage("Incorrect username or password.");
    }
    @Test
    public void hw6(){
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.openProject("G48Automation","Tetyana23");
        String version= gitHubFirstPage.findVersion("selenium-java");
        LOG.info(version);
        Assert.assertEquals("3.141.59",version);
    }

}




