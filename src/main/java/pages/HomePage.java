package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private static final String title = "Домашняя страница";
    public HomePage(WebDriver driver) {
        super
                (driver, title);
    }

private final By homePageTitle = By.xpath("//h1");

    @Step("Проверка произошел ли LogOut")
    public void checkIsLogOut(){
        waitFor25.until(ExpectedConditions.visibilityOf(driver.findElement(homePageTitle)));

    }

}
