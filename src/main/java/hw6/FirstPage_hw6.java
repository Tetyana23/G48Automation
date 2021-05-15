package hw6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FirstPage_hw6 extends BasePage {

    private final By searchField = By.name("q");

    /**
     * конструктор
     * @param driver вебдрайвер
     */
    public FirstPage_hw6(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод который открывает проект автора
     * @param projectName название проекта
     * @param authorName никнейм автора
     */
    @Step("Открывается проект автора")
    public void openProject(String projectName, String authorName) {
        driver.findElement(searchField).sendKeys(projectName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(".//a[contains(text(),'" + authorName + "')]")).click();
    }

}
