package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    public static WebDriver InitDriver(String browserName, String gridURL, String gridPassword) throws MalformedURLException {
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = new RemoteWebDriver(new URL(gridURL.replace("{PASSWORD}", gridPassword)), new ChromeOptions());
                break;
            case "firefox":
                driver = new RemoteWebDriver(new URL(gridURL.replace("{PASSWORD}", gridPassword)), new FirefoxOptions());
                break;
            case "safari":
                driver = new RemoteWebDriver(new URL(gridURL.replace("{PASSWORD}", gridPassword)), new SafariOptions());
                break;
            case "opera":
                driver = new RemoteWebDriver(new URL(gridURL.replace("{PASSWORD}", gridPassword)), new OperaOptions());
                break;
        }
        return driver;
    }

    public static WebDriver InitDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "opera":
                driver = new OperaDriver();
                break;

        }
        return driver;
    }
}