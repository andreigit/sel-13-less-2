package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public abstract class LitecartLoginTestBase extends BrowserTestBase {

    public LitecartLoginTestBase(WebBrowserCode browserCode){
        super(browserCode);
    }

    @BeforeClass
    public void openBrowser() {
        try {
            Runtime.getRuntime().exec(SettingsKt.getRunServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        initDriver();
    }

    @Test
    public void checkLitecartLogin() {
        final String ADMIN = "admin";

        getDriver().get("http://localhost/litecart/admin/");
        getDriver().findElement(By.name("username")).sendKeys(ADMIN);
        getDriver().findElement(By.name("password")).sendKeys(ADMIN);
        getDriver().findElement(By.name("login")).click();
        getDriverWait().until(titleIs("My Store"));
    }

    @AfterClass
    public void closeBrowser() {
        cleanDriver();

        try {
            Runtime.getRuntime().exec(SettingsKt.getStopServerString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
