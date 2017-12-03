package test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static test.DriverFactory.*;

public class LitecartLoginTest {

    private static final String BROWSER = "chrome";

    @BeforeClass
    public void openBrowser() {
        try {
            Runtime.getRuntime().exec(SettingsProvider.getRunServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        startBrowser(BROWSER);
    }

    @Test
    public void checkLitecortLogin() {
        getDriver(BROWSER).get("http://localhost/litecart/admin/");
        getDriver(BROWSER).findElement(By.name("username")).sendKeys("admin");
        getDriver(BROWSER).findElement(By.name("password")).sendKeys("admin");
        getDriver(BROWSER).findElement(By.name("login")).click();
        getWait().until(titleIs("My Store"));
    }

    @AfterClass
    public void closeBrowser() {
        stopBrowser(BROWSER);
        try {
            Runtime.getRuntime().exec(SettingsProvider.getStopServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
