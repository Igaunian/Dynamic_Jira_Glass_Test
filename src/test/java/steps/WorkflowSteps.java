package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import tests.BaseTestBdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkflowSteps extends BaseTestBdd {

    @Given("I am on project's {string}")
    public void iAmOnProjectS(String url) {
        glassPage.navigateToUrl(url);
    }

    @When("I choose the {string}")
    public void iChooseThe(String issueType) {
        glassPage.selectIssuetype(issueType);
    }

    @Then("the workflow {string} appears below the selected issue type's name")
    public void theWorkflowAppearsBelowTheSelectedIssueTypeSName(String name) {
        Assertions.assertTrue(glassPage.checkWorkflowName(name));
    }

    @Then("the workflow {string} {string} appear in the Workflow Transitions table")
    public void theWorkflowSAppearInTheWorkflowTransitionsTable(String transition, String data) {
        List<String> argumentList = new ArrayList<>(Arrays.asList(data.split(",")));
        List<String> returnedList = glassPage.checkWorkflowTransitionData(transition);
        Assertions.assertEquals(argumentList, returnedList);
    }

    @Then("the workflow {string} appears in the Workflow Transitions table")
    public void theWorkflowTransitionAppearsInTheWorkflowTransitionsTable(String data) {
        List<String> argumentList = new ArrayList<>(Arrays.asList(data.split(",")));
        List<String> returnedList = glassPage.checkWorkflowAnalysis();
        Assertions.assertEquals(argumentList, returnedList);
    }

    @Then("the {string} {string} match in the Workflow Transitions table")
    public void theTransitionMatchInTheWorkflowTransitionsTable(String transitions, String counters) {
        List<String> argumentList = new ArrayList<>(Arrays.asList(counters.split(",")));
        List<String> returnedList = glassPage.checkWorkFlowValidatorCounters(transitions);
        Assertions.assertEquals(argumentList, returnedList);
    }

    @Then("the {string} validators {string} are listed in the table")
    public void theValidatorsAreListedInTheTable(String transition, String validators) {
        Assertions.assertEquals(validators, glassPage.getWorkflowValidators(transition));
    }

    @Then("the Show Transition Labels checkbox appears above the workflow diagram")
    public void theShowTransitionLabelsCheckboxAppearsAboveTheWorkflowDiagram() {
        Assertions.assertTrue(glassPage.isCheckBoxPresent());
    }

    @And("I click on the workflow {string} name in the Workflow Transitions table")
    public void iClickOnTheWorkflowNameInTheWorkflowTransitionsTable(String transition) {
        glassPage.clickWorkflowTransitionName(transition);
    }

    @Then("the {string} default {string} are listed in the table")
    public void theDefaultAreListedInTheTable(String transition, String defaultPostFunctions) {
        Assertions.assertTrue(glassPage.getPostFunctions(transition).contains(defaultPostFunctions));
    }

    @Then("the {string} custom {string} are listed in the table")
    public void theCustomAreListedInTheTable(String transition, String customPostFunctions) {
        Assertions.assertTrue(glassPage.getPostFunctions(transition).contains(customPostFunctions));
    }

    @Then("the {string} conditions {string} are listed in the table")
    public void theConditionsAreListedInTheTable(String transition, String conditions) {
        Assertions.assertTrue(glassPage.getConditions(transition).contains(conditions));
    }

    @And("I click on the {string} Validators tab")
    public void iClickOnTheValidatorsTab(String transition) {
        glassPage.clickTabInWorkflowTransitionTable(transition, "Validators");
    }

    @And("I click on the {string} Conditions tab")
    public void iClickOnTheConditionsTab(String transition) {
        glassPage.clickTabInWorkflowTransitionTable(transition, "Conditions");
    }

    @Then("the {string} third party post functions {string} are listed in the table")
    public void theThirdPartyPostFunctionsAreListedInTheTable(String transition, String postFunctions) {
        Assertions.assertTrue(glassPage.getPostFunctions(transition).contains(postFunctions));
    }

    @Then("the {string} third party validators {string} are listed in the table")
    public void theThirdPartyValidatorsAreListedInTheTable(String transition, String validators) {
        Assertions.assertEquals(validators, glassPage.getWorkflowValidators(transition));
    }

    @Then("the {string} third party conditions {string} are listed in the table")
    public void theThirdPartyConditionsAreListedInTheTable(String transition, String conditions) {
        Assertions.assertTrue(glassPage.getConditions(transition).contains(conditions));
    }

    @Then("the {string} {string} is shown in the table")
    public void theIsShownInTheTable(String transition, String conditionGroup) {
        Assertions.assertEquals(conditionGroup, glassPage.getConditionGroup(transition));
    }
}
