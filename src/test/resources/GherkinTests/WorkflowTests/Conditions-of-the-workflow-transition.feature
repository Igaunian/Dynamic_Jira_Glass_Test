
Feature: The conditions of the workflow transition appear in Glass documentation
  Scenario Outline: the workflow conditions appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    And I click on the workflow <transition> name in the Workflow Transitions table
    And I click on the Conditions tab
    Then the <conditions> are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|conditions|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|Only users in project role Administrators can execute this transition., This transition will only execute if there are no Open Crucible reviews related to this issue.|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Finally|Only users in project role Administrators can execute this transition., Only users with Administer Projects permission can execute this transition.|
