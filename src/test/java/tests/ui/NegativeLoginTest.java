package tests.ui;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@Ignore
@Feature("Checking Negative login or password with helping Parametrized class")
@Owner("Tetyana23")
@Severity(SeverityLevel.CRITICAL)
@RunWith(Parameterized.class)
public class NegativeLoginTest extends BaseTest {

    private LoginPage loginPage;
    private final String username;
    private final String password;

    public NegativeLoginTest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Before
    public void setUp() {

        loginPage = new LoginPage(driver);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> result = new ArrayList<>();
            readFile(getProperty("user.dir") + "/src/test/resources/testData/negative_login_data.txt")
                    .forEach(line -> result.add(line.split(", ")));
        return result;

    }

    @Description("Тест нужен, чтобы проверить сообщение об ошибке при вводе негативного логина или пароля")
    @Test
    public void checkNegativeLogin() {
        loginPage.login(this.username, this.password);
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

}
