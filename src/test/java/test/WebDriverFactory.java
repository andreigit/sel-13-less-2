package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    public static WebDriver CreateDriver(WebDriverCode driverCode) {
        switch (driverCode) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            case IE:
                return new InternetExplorerDriver();
            default:
                throw new IllegalArgumentException("driverCode");
        }
    }

}
