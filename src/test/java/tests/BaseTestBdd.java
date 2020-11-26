package tests;

import org.openqa.selenium.WebDriver;
import pages.GlassPage;
import pages.ProjectPage;

public class BaseTestBdd {
    protected static final String BASEURL = System.getenv("BASEURL");
    protected static final String GLASSURL = System.getenv("GLASSURL");
    protected static final String PROJECTURL = System.getenv("PROJECTURL");
    protected static final String GRID_URL = System.getenv("GRID_URL");
    protected static final String BROWSER = System.getenv("BROWSER");
    protected static final String USERNAME = System.getenv("USERNAME");
    protected static final String PASSWORD = System.getenv("PASSWORD");
    protected static final String ADMIN_USERNAME = System.getenv("ADMIN_USERNAME");
    protected static final String ADMIN_PASSWORD = System.getenv("ADMIN_PASSWORD");
    protected static final String PROJECT_ADMIN_USERNAME = System.getenv("PROJECT_ADMIN_USERNAME");
    protected static final String PROJECT_ADMIN_PASSWORD = System.getenv("PROJECT_ADMIN_PASSWORD");
    public static GlassPage glassPage;
    public static ProjectPage projectPage;
    protected static WebDriver driver;



}
