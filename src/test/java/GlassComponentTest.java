import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.GlassPage;
import pages.ProjectPage;

import java.net.MalformedURLException;

public class GlassComponentTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;

    public static String componentName;
    public static String componentDescription;
    public static String componentAssignee;

    public static void setComponentName(String componentName) {
        GlassComponentTest.componentName = componentName;
    }

    public static void setComponentDescription(String componentDescription) {
        GlassComponentTest.componentDescription = componentDescription;
    }

    public static void setComponentAssignee(String componentAssignee) {
        GlassComponentTest.componentAssignee = componentAssignee;
    }

    @BeforeAll
    @ParameterizedTest()
    @CsvFileSource(resources = "/component_data.csv", numLinesToSkip = 1)
    public static void setUp() throws MalformedURLException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
        projectPage.login(USERNAME, PASSWORD);
        projectPage.createComponent(componentName, componentDescription, componentAssignee);
    }

    @Test
    public void viewComponentName() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentExists(componentName));
    }

    @Test
    public void viewComponentsAssignee() {
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentAssigneePresent());
    }

    @Test
    public void viewComponentDescription(){
        glassPage.navigateToComponentsTab();
        Assertions.assertTrue(glassPage.doesComponentDescriptionPresent(componentDescription));
    }


    @AfterAll
    public static void teardown() {
//        projectPage.deleteComponent();
    }
}

