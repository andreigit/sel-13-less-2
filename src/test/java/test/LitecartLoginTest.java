package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LitecartLoginTest {

    private static final WebDriverCode DEFAULT_BROWSER = WebDriverCode.CHROME;
    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 10;

    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeClass
    public void openBrowser() {
        try {
            Runtime.getRuntime().exec(SettingsProvider.getRunServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        driver = WebDriverFactory.CreateDriver(DEFAULT_BROWSER);
        driverWait = new WebDriverWait(driver, DEFAULT_TIMEOUT_IN_SECONDS);
    }

    @Test
    public void checkLitecartLogin() {
        final String ADMIN = "admin";

        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys(ADMIN);
        driver.findElement(By.name("password")).sendKeys(ADMIN);
        driver.findElement(By.name("login")).click();
        driverWait.until(titleIs("My Store"));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        driver = null;
        driverWait = null;

        try {
            Runtime.getRuntime().exec(SettingsProvider.getStopServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
