package test

import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions.titleIs
import org.testng.Assert
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class MyFirstTest: BrowserTestBase() {
    @BeforeClass
    fun openBrowser() {
        initDriver()
    }

    @Test
    fun checkSoftwareTestingSite() {
        driver!!.get("http://software-testing.ru/")
        driverWait!!.until<Boolean>(titleIs("Software-Testing.Ru"))
        driver!!.findElement(By.xpath("//span[text()='Библиотека']")).click()
        Assert.assertEquals("Библиотека", driver!!.title)
    }

    @AfterClass
    fun closeBrowser() {
        cleanDriver()
    }
}