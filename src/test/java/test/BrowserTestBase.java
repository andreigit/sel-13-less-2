package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.webdriverfactory.WebDriverFactoryKt;

public abstract class BrowserTestBase {

    private static final WebBrowserCode DEFAULT_BROWSER = WebBrowserCode.CHROME;
    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 10;

    private final WebBrowserCode browser;
    private final long timeoutInSeconds;

    private WebDriver driver;
    private WebDriverWait driverWait;

    protected WebDriver getDriver() { return driver; }
    protected WebDriverWait getDriverWait() { return driverWait; }

    public BrowserTestBase(WebBrowserCode browser, long timeoutInSeconds) {
        this.browser = browser;
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public BrowserTestBase(WebBrowserCode browser) {
        this(browser, DEFAULT_TIMEOUT_IN_SECONDS);
    }

    public BrowserTestBase(long timeoutInSeconds) {
        this(DEFAULT_BROWSER, timeoutInSeconds);
    }

    public BrowserTestBase() {
        this(DEFAULT_BROWSER, DEFAULT_TIMEOUT_IN_SECONDS);
    }

    protected void initDriver()
    {
        driver = WebDriverFactoryKt.createWebDriver(browser);
//        driver = WebDriverFactory.createDriver(browser);
        driverWait = new WebDriverWait(driver, timeoutInSeconds);
    }

    protected void cleanDriver() {
        driver.quit();
        driver = null;
        driverWait = null;
    }
}
