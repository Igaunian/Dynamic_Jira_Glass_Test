import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.GlassPage;
import pages.ProjectPage;

import java.io.IOException;

public class PermissionTest extends BaseTest {
    public static GlassPage glassPage;
    public static ProjectPage projectPage;

    @BeforeAll
    public static void setUp() throws CsvException, IOException {
        BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
    }

    @DisplayName("The schemes editing link works according to the permissions in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/schemesEditingPermissionTest_data.csv", numLinesToSkip = 1)
    public void schemeLinkWorkCheck(String username, String password, String projectPage, String editPage, String expectedResult) {
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.projectPage.navigateToUrl(projectPage);
        glassPage.clickSchemeTab();
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(glassPage.isChangeButtonPresent(editPage));
                break;
            case "able":
                Assertions.assertTrue(glassPage.isChangeButtonPresent(editPage));
                break;
        }
    }

    @AfterEach
    public void logout() {
        projectPage.logout();
    }
}