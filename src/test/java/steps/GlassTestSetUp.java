package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.GlassPage;
import pages.ProjectPage;
import tests.BaseTestBdd;
import util.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class GlassTestSetUp extends BaseTestBdd {

    @Before
    public static void setUp() {
        driver = WebDriverFactory.initDriver(BROWSER);
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        projectPage.login(USERNAME, PASSWORD);
    }

    @After
    public static void tearDown() {
        driver.quit();
    }

}
