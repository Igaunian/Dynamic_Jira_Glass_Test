package tests;

import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.GlassPage;
import pages.ProjectPage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class GlassComponentTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;

    @BeforeAll
    public static void setUp() throws CsvException, IOException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("src/test/resources/component_data.csv"));
        List<String[]> records = reader.readAll();
        for (String[] record : records) {
            projectPage.createComponent(record[1],record[2],record[3],record[4]);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public void viewComponentName(String projectUrl, String ProjectComponentURL, String componentName, String componentDescription, String componentAssignee) {
        glassPage.navigateToComponentsTab(projectUrl);
        Assertions.assertTrue(glassPage.doesComponentExist(componentName));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public void viewComponentsAssignee(String projectUrl, String ProjectComponentURL, String componentName, String componentDescription, String componentAssignee) {
        glassPage.navigateToComponentsTab(projectUrl);
        Assertions.assertTrue(glassPage.isComponentAssigneePresent());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public void viewComponentDescription(String projectUrl, String ProjectComponentURL, String componentName, String componentDescription, String componentAssignee){
        glassPage.navigateToComponentsTab(projectUrl);
//        TODO: softassert
        Assertions.assertTrue(glassPage.isComponentDescriptionPresent(componentDescription));
    }

    @AfterAll
    public static void teardown() throws IOException, CsvException {
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("src/test/resources/component_data.csv"));
        List<String[]> records = reader.readAll();
        String ProjectComponentURL = null;
        for (String[] record : records) {
            ProjectComponentURL = record[1];
        }
        projectPage.deleteComponent(ProjectComponentURL);
    }
}

