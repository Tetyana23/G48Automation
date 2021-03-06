package hw6;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");
    private final By errorMessageText = By.xpath("//div[@class = 'flash flash-full flash-error ']/div");

    public LoginPageObject(WebDriver driver){
        super(driver);
    }

    @Step("Логин")
    public void login(String username, String password){
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
    @Step("Проверяется валидационное сообщение об ошибке")
    public void validateErrorMessage(String errorMessage){
        Assert.assertEquals(errorMessage, driver.findElement(errorMessageText).getText());
    }

}
