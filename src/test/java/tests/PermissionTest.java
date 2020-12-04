package tests;

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

    @BeforeEach
    public void initEach() throws CsvException, IOException {
//        tests.BaseTest.setUp();
        glassPage = new GlassPage(driver);
        projectPage = new ProjectPage(driver);
    }

    @DisplayName("The change scheme link works according to the permissions in Glass documentation\n")
    @ParameterizedTest
    @CsvFileSource(resources = "/schemesChangePermissionTest_data.csv", numLinesToSkip = 1)
    public void schemeChangeGearWorkCheck(String username, String password, String projectPage, String editPage, String expectedResult) {
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.projectPage.navigateToUrl(projectPage);
        PermissionTest.glassPage.clickSchemeTab();
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(glassPage.isChangeButtonPresent(editPage));
                break;
            case "able":
                Assertions.assertTrue(glassPage.isChangeButtonPresent(editPage));
                break;
        }
    }

    @DisplayName("The schemes editing link works according to the permissions in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/schemesEditingPermissionTest_data.csv", numLinesToSkip = 1)
    public void schemeEditingLinkWorkCheck(String username, String password, String projectPage, String editPage, String expectedResult) {
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.projectPage.navigateToUrl(projectPage);
        PermissionTest.glassPage.clickSchemeTab();
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(glassPage.clickSchemeSettingsLink());
                break;
            case "able":
                Assertions.assertTrue(glassPage.clickSchemeSettingsLink());
                break;
        }
    }

    @DisplayName("The permissions editing link works according to the permissions in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/permissionEditingPermissionTest_data.csv", numLinesToSkip = 1)
    public void permissionLinkWorkCheck(String username, String password, String projectPage, String expectedResult){
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.projectPage.navigateToUrl(projectPage);
        PermissionTest.glassPage.clickPermissionTab();
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(PermissionTest.glassPage.clickPermissionSettingsLink());
                break;
            case "able":
                Assertions.assertTrue(PermissionTest.glassPage.clickPermissionSettingsLink());
                break;
        }
    }

    @DisplayName("The components editing link works according to the permissions in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/componentEditingPermissionTest_data.csv", numLinesToSkip = 1)
    public void componentEditingLinkWorkCheck(String username, String password, String projectPage, String expectedResult){
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.glassPage.navigateToComponentsTab(projectPage);
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(PermissionTest.glassPage.clickComponentSettingsLink());
                break;
            case "able":
                Assertions.assertTrue(PermissionTest.glassPage.clickComponentSettingsLink());
                break;
        }
    }

    @DisplayName("The workflow editing link works according to the permissions in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflowEditingPermissionTest_data.csv", numLinesToSkip = 1)
    public void workflowEditingLinkWorkCheck(String username, String password, String projectPage, String issueType, String expectedResult){
        PermissionTest.projectPage.login(System.getenv(username), System.getenv(password));
        PermissionTest.projectPage.navigateToUrl(projectPage);
        PermissionTest.glassPage.selectIssuetype(issueType);
        switch (expectedResult) {
            case "unable":
                Assertions.assertFalse(PermissionTest.glassPage.clickWorkflowSettingsQuickLink());
                break;
            case "able":
                Assertions.assertTrue(PermissionTest.glassPage.clickWorkflowSettingsQuickLink());
                break;
        }
    }


    @AfterEach
    public void logout() {
        projectPage.logout();
    }
}