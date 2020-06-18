package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public final int TIMEOUT = Integer.parseInt(System.getenv("TIMEOUT"));
    static final String BASEURL = System.getenv("BASEURL");
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, TIMEOUT);
    }

    public void navigateToUrl() {
        driver.get(BASEURL);
    }
    public void navigateToUrl(String URL) {
        driver.get(BASEURL + URL);
    }
}
