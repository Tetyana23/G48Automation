package hw7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class ParameterSearch extends BaseTest {
    private LoginPageObject loginPage;
    private FirstPage_hw7 gitHubFirstPage;
    private SearchPage searchPage;
    private String authorName;

    public ParameterSearch(String authorName) {
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
        result.add(new String[]{"sudorenwe"});
        result.add(new String[]{"kgalchinskii"});
        result.add(new String[]{"Daimon2112"});
        result.add(new String[]{"bezpalkovitaliiwe"});
        result.add(new String[]{"geonnia"});
        result.add(new String[]{"RomaMalanchuk"});
        result.add(new String[]{"BKuso"});
        result.add(new String[]{"Tetyana23"});
        return result;
    }

    @Test
    public void checkAuthorName() {
        loginPage.login(System.getProperty("username"), System.getProperty("password"));
        gitHubFirstPage.searchProject("G48Automation");
        Assert.assertTrue(searchPage.existProject(authorName));
    }


}
