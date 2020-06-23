import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.GlassPage;
import pages.ProjectPage;

import java.io.IOException;

public class WorkflowTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;

    @BeforeAll
    public static void setUp() throws CsvException, IOException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
    }

    @DisplayName("Verify that the workflow appears in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflow_data.csv", numLinesToSkip = 1)
    public void workflowTest1() {

    }
}

