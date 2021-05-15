package hw6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PomePage extends BasePage{

    private final By pomFile = By.xpath(".//a[contains(text(),'pom.xml')]");

    /**
     * конструктор
     * @param driver вебдрайвер
     */
    public PomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * метор который находит версию артефакта
     * @param artifactName название атрефакта
     * @return версию артефакта
     */
    @Step("Поиск версии артефакта")
    public String findVersion(String artifactName) {
        driver.findElement(pomFile).click();

        String artifactNameId = driver.findElement(By.xpath(".//td[contains(.,'"+artifactName+"')]")).getAttribute("id");
        int artifactNameNumber = Integer.parseInt(artifactNameId.substring(2)) + 1;
        String artifactVersionId = artifactNameId.substring(0, 2) + artifactNameNumber;
        String versionText = driver.findElement(By.id(artifactVersionId)).getText();
        String part = versionText.split(">")[1];
        String version = part.split("<")[0];
        return version;
    }


}
