import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.ProjectPage;
import java.io.IOException;


public class GlassVersionTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;
    private static String versionName = System.getenv("VERSION_NAME");
    private static String startDate = System.getenv("START_DATE");
    private static String releaseDate = System.getenv("RELEASE_DATE");
    private static String description = System.getenv("COMPONENT_DESCRIPTION");


    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
        projectPage.createNewVersion(versionName ,startDate, releaseDate, description);
    }

    @Test
    public void viewVersionName(){
        glassPage.navigateToVersionsTab();
        Assertions.assertTrue(glassPage.doesVersioinExists(versionName));
    }

    @Test
    public void viewVersionDescription(){
        glassPage.navigateToVersionsTab();
        Assertions.assertTrue(glassPage.doesVersionDescriptionPresent(description));
    }

    @Test
    public void viewVersionStartDate(){
        glassPage.navigateToVersionsTab();
        Assertions.assertTrue(glassPage.doesVersionStartDatePresent(startDate));
    }

    @Test
    public void viewVersionReleaseDate(){
        glassPage.navigateToVersionsTab();
        Assertions.assertTrue(glassPage.doesVersionReleaseDatePresent(releaseDate));
    }

    @AfterAll
        public static void teardown(){
            projectPage.deleteVersion();
    }
}
