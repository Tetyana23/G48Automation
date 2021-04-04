package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class FirstPage_hw6 extends BasePage {

    private final By searchField = By.name("q");
    public final By pomFile = By.xpath(".//a[contains(text(),'pom.xml')]");

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
    public void openProject(String projectName, String authorName) {
        driver.findElement(searchField).sendKeys(projectName);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(".//a[contains(text(),'" + authorName + "')]")).click();
    }

    /**
     * метор который находит версию артефакта
     * @param artifactName название атрефакта
     * @return версию артефакта
     */
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
