package tests.ui;

import io.qameta.allure.*;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.getProperty;

@Feature("Issue Creation")
@Owner("Tetyana23")
@Severity(SeverityLevel.NORMAL)
public class IssueCreationTest extends BaseTest {

    private List<String> labels = new ArrayList<>();

    private LoginPage page;

    @Before
    public void prepareData() {
        this.page = new LoginPage(this.driver);
        labels.add("bug");
        labels.add("invalid");
    }

    @Description("Тест нужен, чтобы создать новую Issue")
    @Test
    public void checkIssueCreation() {
        this.page.login(getProperty("username"), getProperty("password"))
                .openProjectG48()
                .openIssues()
                .openCreationPage()
                .createNewIssue(
                        "Automated Issue Title",
                        "Test body. Please ignore me!", labels)
                .validateIssue("Automated Issue Title",
                        "Test body. Please ignore me!", labels)
                .logout();

    }
}

