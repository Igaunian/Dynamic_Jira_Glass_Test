import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
    public static void setUp() throws CsvException, IOException, InterruptedException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("src/test/resources/component_data.csv"));
        List<String[]> records = reader.readAll();
        for (String[] record : records) {
            projectPage.createComponent(record[0], record[1], record[2]);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public void viewComponentName(String componentName) {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentExists(componentName));
    }

    @Test
    public void viewComponentsAssignee() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentAssigneePresent());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public void viewComponentDescription(String componentDescription){
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentDescriptionPresent(componentDescription));
    }

    @AfterAll
    public static void teardown() {
//        projectPage.deleteComponent();
    }
}

