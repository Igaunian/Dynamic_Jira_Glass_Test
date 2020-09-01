
Feature: The Show Transition Labels checkbox appears in Glass documentation
  Scenario Outline: the workflow appears on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    Then the Show Transition Labels checkbox appears above the workflow diagram

    Examples:
      |Glass documentation page|issue type|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|
