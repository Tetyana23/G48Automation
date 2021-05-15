package hw9;

import hw9.helpers.ExcelHelper;
import hw9.issues.IssueCreationPage;
import hw9.issues.IssueInfoPage;
import hw9.issues.IssuesPage;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hw9.helpers.FileHelper.readFile;
import static java.lang.System.getProperty;

@Feature("Rewriting reading data from a file to reading data from Excel. Also creating a switch")
@Story("HW9")
@Owner("Tetyana23")
@Severity(SeverityLevel.TRIVIAL)
@RunWith(Parameterized.class)
public class IssueHW9Test extends BaseTest {
    private final static Logger LOG = LogManager.getLogger("вычитка данных");
    private LoginPageObject loginPage;
    private FirstPage gitHubFirstPage;
    private SearchPage searchPage;
    private String logger = "issue";
    private IssuesPage issuesPage;
    private IssueCreationPage issueCreationPage;
    private IssueInfoPage issueInfoPage;
    private HomePage homePage;

    private final String projectName;
    private final String authorName;
    private final String title;
    private final String comment;
    private final List<String> labels;


    public IssueHW9Test(String projectName, String authorName, String title, String comment, List<String> labels) {
        this.projectName = projectName;
        this.authorName = authorName;
        this.title = title;
        this.comment = comment;
        this.labels = labels;
    }


    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver, logger);
        gitHubFirstPage = new FirstPage(driver, logger);
        searchPage = new SearchPage(driver, logger);
        issuesPage = new IssuesPage(driver);
        issueCreationPage = new IssueCreationPage(driver);
        issueInfoPage = new IssueInfoPage(driver);
        homePage = new HomePage(driver);
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        LOG.debug("вычитка данных");
        List<Object[]> result = new ArrayList<>();
        LOG.debug("начинаю читать файл");


    if (Boolean.parseBoolean(System.getProperty("useFile"))) {
            ExcelHelper.readDataFromExcelFile(
                    "/Users/tatianakurylenko/IdeaProjects/G48AutomationTanya2/src/test/resources/testData/hw9.xls",
                    "Sheet1",
                    false)
                    .forEach(line -> {
                        LOG.debug("нулевой елемент- название проекта, первый- название автора, второй- title, третий- comment, остальные лейблы");
                        result.add(new Object[]{line.get(0), line.get(1), line.get(2), line.get(3), line.subList(4, line.size())});
                        LOG.debug("сохраняю параметры в результирующий список");
                    });
        } else {
            readFile(getProperty("user.dir") + "/src/test/resources/testData/issue.txt")
                    .forEach(line -> {
                        LOG.debug("разделяю строку запятой и пробелом");
                        String[] array = line.split(", ");
                        LOG.debug("нулевой елемент- название проекта, первый- название автора, второй- title, третий- comment, остальные лейблы");
                        LOG.debug("копируем елементы начиная с четвертого и сохраняем их в List<String>");
                        result.add(new Object[]{array[0], array[1], array[2], array[3], Arrays.asList(Arrays.copyOfRange(array, 4, array.length))});
                        LOG.debug("сохраняю параметры в результирующий список");
                    });
        }
        LOG.debug("закончила читать файл, возвращаю результат");
        return result;
    }


    @Description("Тест нужен, чтобы авторизоваться, перейти в проект. Также, чтобы создать новые Issue путем извлечения данных из Excel")
    @Test
    public void checkIssue() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject(projectName);
        searchPage.openProject(authorName);
        issuesPage.openIssues();
        issuesPage.openCreationPage();
        issueCreationPage.createNewIssue(title, comment, labels);
        issueInfoPage.validateIssue(title, comment, labels);
        issueInfoPage.logout();
        homePage.checkIsLogOut();


    }
}
