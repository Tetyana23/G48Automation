package hw7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод, который открывает проект автора
     * @param authorName имя автора
     */
    @Step("Открытие проекта автора")
    public void openProject(String authorName) {
        driver.findElement(By.xpath(".//a[contains(text(),'" + authorName + "')]")).click();
    }

    /**
     * Метод, который проверяет существует ли проект автора
     * @param authorName имя автора
     * @return отображается такой проект, или нет
     */
    @Step("Проверка на существование проекта автора")
    public boolean existProject (String authorName){
        return driver.findElement(By.xpath(".//a[contains(text(),'" + authorName + "')]")).isDisplayed();
    }


}
