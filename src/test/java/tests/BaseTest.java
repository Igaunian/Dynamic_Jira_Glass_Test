package tests;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.GlassPage;
import pages.ProjectPage;
import util.WebDriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
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

    @BeforeAll
    public static void setUp() throws CsvException, IOException {
        driver = WebDriverFactory.initDriver(BROWSER);
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
