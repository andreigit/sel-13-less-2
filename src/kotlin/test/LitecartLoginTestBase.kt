package test

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions.titleIs
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.io.IOException

abstract class LitecartLoginTestBase(browser: WebBrowserCode) : BrowserTestBase(browser) {
    @BeforeClass
    fun openBrowser() {
        try {
            Runtime.getRuntime().exec(getRunServerString())
        } catch (e: IOException) {
            e.printStackTrace()
        }

        initDriver()
    }

    @Test
    fun checkLitecartLogin() {
        val admin = "admin"

        driver.get("http://localhost/litecart/admin/")
        driver.findElement(By.name("username")).sendKeys(admin)
        driver.findElement(By.name("password")).sendKeys(admin)
        driver.findElement(By.name("login")).click()
        driverWait.until<Boolean>(titleIs("My Store"))
    }

    @AfterClass
    fun closeBrowser() {
        cleanDriver()

        try {
            Runtime.getRuntime().exec(getStopServerString())
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}