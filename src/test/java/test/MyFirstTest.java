package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends BrowserTestBase {

    @BeforeClass
    public void openBrowser() {
        initDriver();
    }

    @Test
    public void checkSoftwareTestingSite() {
        getDriver().get("http://software-testing.ru/");
        getDriverWait().until(titleIs("Software-Testing.Ru"));
        getDriver().findElement(By.xpath("//span[text()='Библиотека']")).click();
        Assert.assertEquals("Библиотека", getDriver().getTitle());
    }

    @AfterClass
    public void closeBrowser() {
        cleanDriver();
    }
}
