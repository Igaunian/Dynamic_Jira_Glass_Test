
Feature: The workflow transition counters match in Glass documentation
  Scenario Outline: the workflow transition data appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    And I click on the <transition> name
    Then the transition <counters> match in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|transition|counters|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|To Do|Conditions 0, Validators 0, Post Functions 6|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|Conditions 2, Validators 1, Post Functions 6|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Finally|Conditions 2, Validators 0, Post Functions 6|
