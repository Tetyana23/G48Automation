package tests.ui;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

@Feature("Positive autorization")
@Story("Github auth")
@Owner("Tetyana23")
@Severity(SeverityLevel.NORMAL)
public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @Before
    public void setUp() {

        loginPage = new LoginPage(driver);
    }

    @Test
    public void checkNegativeLogin() {
        loginPage.login("Tetyana23", "TTTTT23");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }


    @Description("Тест нужен чтобы показать последнее сообщение коммита")
    @TmsLink("MR-25")
    @Issues({
            @Issue(""),
            @Issue("")}
            )
    @DisplayName("Показать значение коммита")
    @Test
    public void showCommitMessageTest() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"))
                .openProjectG48()
                .showCommitMessage()
                .logout();
    }

}




