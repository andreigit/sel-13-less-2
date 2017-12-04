package test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import test.WebBrowserCode.*

fun createWebDriver(browserCode: WebBrowserCode): WebDriver =
    when (browserCode) {
        CHROME -> ChromeDriver()
        FIREFOX -> FirefoxDriver()
        EDGE -> EdgeDriver()
        IE -> InternetExplorerDriver()
        else -> throw IllegalArgumentException("Unexpected browser code.")
    }
