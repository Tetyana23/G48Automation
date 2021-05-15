package hw6;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Feature("Moving to project. Searching the library version and Logging it to Console")
@Story("HW6")
@Owner("Tetyana23")
@Severity(SeverityLevel.CRITICAL)
public class LoginPageTest_HW6 extends BaseTest {
    private final static Logger LOG = LogManager.getLogger("Version");

    private LoginPageObject loginPage;
    private FirstPage_hw6 gitHubFirstPage;
    private PomePage pomePage;

    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver);
        gitHubFirstPage = new FirstPage_hw6(driver);
        pomePage = new PomePage(driver);
    }
    @Description("Positive Autorization")
    @Test
    public void checkLogin() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        // loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Description("Тест нужен, чтобы перейти в проект. Также, чтобы найти версию библиотеки selenium-java и залогировать ее в консоль")
    @Test
    public void hw6() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.openProject("G48Automation", "Tetyana23");
        String version = pomePage.findVersion("selenium-java");
        LOG.info(version);
        Assert.assertEquals("3.141.59", version);
    }

}




