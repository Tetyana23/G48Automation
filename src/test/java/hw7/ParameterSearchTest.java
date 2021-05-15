package hw7;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@Feature("Searching the Author project on GitHub using Parametrized class")
@Story("HW7")
@Owner("Tetyana23")
@Severity(SeverityLevel.NORMAL)

@RunWith(Parameterized.class)
public class ParameterSearchTest extends BaseTest {
    private LoginPageObject loginPage;
    private FirstPage_hw7 gitHubFirstPage;
    private SearchPage searchPage;
    private String authorName;

    public ParameterSearchTest(String authorName) {
        this.authorName = authorName;

    }

    @Before
    public void setUp() {
        loginPage = new LoginPageObject(driver);
        gitHubFirstPage = new FirstPage_hw7(driver);
        searchPage = new SearchPage(driver);
    }

    @Parameterized.Parameters
    public static List<String[]> data() {
        List<String[]> result = new ArrayList<>();
        result.add(new String[]{"sudoren"});
        result.add(new String[]{"kgalchinskii"});
        result.add(new String[]{"Daimon2112"});
        result.add(new String[]{"bezpalkovitalii"});
        result.add(new String[]{"geonnia"});
        result.add(new String[]{"RomaMalanchuk"});
        result.add(new String[]{"BKuso"});
        result.add(new String[]{"Tetyana23"});
        return result;
    }
    @Description("Тест нужен, чтобы найти Проект автора в поисковике ГитХаб истользуя Параметризованный класс")
    @Test
    public void checkAuthorName() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        Assert.assertTrue(searchPage.existProject(authorName));
    }


}
