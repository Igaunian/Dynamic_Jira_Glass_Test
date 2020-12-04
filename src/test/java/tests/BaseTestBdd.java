package tests;

import org.openqa.selenium.WebDriver;
import pages.GlassPage;
import pages.ProjectPage;

public class BaseTestBdd {
    protected static final String BROWSER = System.getenv("BROWSER");
    protected static final String USERNAME = System.getenv("USERNAME");
    protected static final String PASSWORD = System.getenv("PASSWORD");

    public static GlassPage glassPage;
    public static ProjectPage projectPage;
    protected static WebDriver driver;



}
