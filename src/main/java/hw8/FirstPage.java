package hw8;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstPage extends BaseAuthorizedPage {
    private final By searchField = By.name("q");


    /**
     * конструктор
     *
     * @param driver вебдрайвер
     */
    public FirstPage(WebDriver driver, String title) {

        super(driver, title);
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



}
