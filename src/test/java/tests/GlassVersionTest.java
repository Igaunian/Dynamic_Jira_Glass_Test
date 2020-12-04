package tests;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.GlassPage;
import pages.ProjectPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class GlassVersionTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;


    @BeforeAll
    public static void setUp() throws IOException, CsvException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("src/test/resources/version_data.csv"));
        List<String[]> records = reader.readAll();
        for (String[] record : records) {
            projectPage.createNewVersion(record[0], record[1], record[2], record[3]);
        }
    }

    @Test
    public void viewVersionName(String projectUrl, String versionName, String startDate, String releaseDate, String description){
        glassPage.navigateToVersionsTab(projectUrl);
        Assertions.assertTrue(glassPage.doesVersionExist(versionName));
    }

    @Test
    public void viewVersionDescription(String projectUrl, String versionName, String startDate, String releaseDate, String description){
        glassPage.navigateToVersionsTab(projectUrl);
        Assertions.assertTrue(glassPage.isVersionDescriptionPresent(description));
    }

    @Test
    public void viewVersionStartDate(String projectUrl, String versionName, String startDate, String releaseDate, String description){
        glassPage.navigateToVersionsTab(projectUrl);
        Assertions.assertTrue(glassPage.isVersionStartDatePresent(startDate));
    }

    @Test
    public void viewVersionReleaseDate(String projectUrl, String versionName, String startDate, String releaseDate, String description){
        glassPage.navigateToVersionsTab(projectUrl);
        Assertions.assertTrue(glassPage.isVersionReleaseDatePresent(releaseDate));
    }

    @AfterAll
        public static void teardown(){
            projectPage.deleteVersion();
    }
}
