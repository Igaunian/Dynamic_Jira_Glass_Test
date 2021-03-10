package tests;

import org.openqa.selenium.WebDriver;
import pages.GlassPage;

public class BaseTestBdd {
    protected static final String BROWSER = System.getenv("BROWSER");
    protected static final String USERNAME = System.getenv("USERNAME");
    protected static final String PASSWORD = System.getenv("PASSWORD");

    public static GlassPage glassPage;
    protected static WebDriver driver;

}
