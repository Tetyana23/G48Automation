package hw9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {

    private final By loginField = By.name("login");
    private final By passwordField = By.name("password");
    private final By submitButton = By.name("commit");

    public LoginPageObject(WebDriver driver, String title){

        super(driver, title);
    }

    public void login(String username, String password){
        driver.findElement(loginField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }
}
