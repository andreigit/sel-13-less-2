package test

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import kotlin.properties.Delegates

private fun defaultBrowser() = WebBrowserCode.CHROME
private const val BROWSER_DEFAULT_TIMEOUT_IN_SECONDS = 10L

abstract class BrowserTestBase {
    private val browser: WebBrowserCode
    private val timeoutInSeconds: Long

    protected var driver: WebDriver by Delegates.notNull()
        private set

    protected var driverWait: WebDriverWait by Delegates.notNull()
        private set

    constructor(browser: WebBrowserCode, timeoutInSeconds: Long) {
        this.browser = browser
        this.timeoutInSeconds = timeoutInSeconds
    }

    constructor(browser: WebBrowserCode): this(browser, BROWSER_DEFAULT_TIMEOUT_IN_SECONDS)

    constructor(timeoutInSeconds: Long): this(defaultBrowser(), timeoutInSeconds)

    constructor(): this(defaultBrowser(), BROWSER_DEFAULT_TIMEOUT_IN_SECONDS)

    protected fun initDriver() {
        driver = createWebDriver(browser)
        driverWait = WebDriverWait(driver, timeoutInSeconds)
    }

    protected fun cleanDriver() {
        driver.quit()
        driver.close()
    }
}