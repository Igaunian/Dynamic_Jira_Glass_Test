package tests;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.GlassPage;
import pages.ProjectPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @CsvFileSource(resources = "/workflowTest1_data.csv", numLinesToSkip = 1)
    public void workflowTest1(String page, String issueType, String name) {
        projectPage.navigateToUrl(page);
        glassPage.selectIssuetype(issueType);
        Assertions.assertTrue(glassPage.checkWorkflowName(name));
    }

    @DisplayName("Verify that the workflow transition data appear in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflowTest2_data.csv", numLinesToSkip = 1)
    public void workflowTest2(String page, String issueType, String transitions) {
        projectPage.navigateToUrl(page);
        glassPage.selectIssuetype(issueType);
        List<String> argumentList = new ArrayList<String>(Arrays.asList(transitions.split(",")));
        List<String> returnedList = glassPage.checkWorkflowTransitionNames();
        Assertions.assertEquals(argumentList, returnedList);
    }

    @DisplayName("Verify that the workflow transition analysis appears in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflowTest3_data.csv", numLinesToSkip = 1)
    public void workflowTest3(String page, String issueType, String transitions) {
        projectPage.navigateToUrl(page);
        glassPage.selectIssuetype(issueType);
        List<String> argumentList = new ArrayList<String>(Arrays.asList(transitions.split(",")));
        List<String> returnedList = glassPage.checkWorkflowAnalysis();
        Assertions.assertEquals(argumentList, returnedList);
    }

    @DisplayName("The workflow transition counters match in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflowTest4_data.csv", numLinesToSkip = 1)
    public void workflowTest4(String page, String issueType, String transitions, String counters) {
        projectPage.navigateToUrl(page);
        glassPage.selectIssuetype(issueType);
        List<String> argumentList = new ArrayList<String>(Arrays.asList(counters.split(",")));
        List<String> returnedList = glassPage.checkWorkFlowValidatorCounters(transitions);
        Assertions.assertEquals(argumentList, returnedList);
    }

    @DisplayName("The validators of the workflow transition appear in Glass documentation")
    @ParameterizedTest
    @CsvFileSource(resources = "/workflowTest5_data.csv", numLinesToSkip = 1)
    public void workflowTest5(String page, String issueType, String transition, String validator) {
        projectPage.navigateToUrl(page);
        glassPage.selectIssuetype(issueType);
        Assertions.assertEquals(validator, glassPage.getWorkflowValidator(transition));
    }
}



