package hw9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseAuthorizedPage {

    public SearchPage(WebDriver driver, String title) {

        super(driver, title);
    }

    /**
     * Метод, который открывает проект автора
     * @param authorName имя автора
     */
    public void openProject(String authorName) {
        driver.findElement(By.xpath(".//a[contains(text(),'" + authorName + "')]")).click();
    }



}
