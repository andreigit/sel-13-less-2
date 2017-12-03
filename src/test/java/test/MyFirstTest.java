package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private static final WebDriverCode DEFAULT_BROWSER = WebDriverCode.CHROME;
    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 10;

    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void openBrowser() {
        driver = WebDriverFactory.CreateDriver(DEFAULT_BROWSER);
        driverWait = new WebDriverWait(driver, DEFAULT_TIMEOUT_IN_SECONDS);
    }

    @Test
    public void checkSoftwareTestingSite() {
        driver.get("http://software-testing.ru/");
        driverWait.until(titleIs("Software-Testing.Ru"));
        driver.findElement(By.xpath("//span[text()='Библиотека']")).click();
        Assert.assertEquals("Библиотека", driver.getTitle());
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        driver = null;
        driverWait = null;
    }
}
