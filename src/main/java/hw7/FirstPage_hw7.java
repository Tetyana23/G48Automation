package hw7;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FirstPage_hw7 extends BasePage {
    private final static Logger LOG = LogManager.getLogger("Tab");
    private final By searchField = By.name("q");
    private final By tabSection = By.xpath(".//ul[contains(@class,'UnderlineNav-body')]");
    private final By tabName = By.xpath("//span[@data-content]");

    /**
     * конструктор
     *
     * @param driver вебдрайвер
     */
    public FirstPage_hw7(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод который исчет все проекты с названием
     *
     * @param projectName название проекта
     */
    @Step("Поиск всех проектов с названием")
    public void searchProject(String projectName) {
        driver.findElement(searchField).sendKeys(projectName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    /**
     * Метод, который печатает все Табы
     */
    @Step("Печать всех Табов")
    public void printTabs() {
        List<WebElement> list = driver.findElement(tabSection).findElements(tabName);
        for (WebElement element : list) {
            LOG.info(element.getText());
        }


    }


}
