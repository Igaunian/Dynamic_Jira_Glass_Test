
Feature: The default post functions of the workflow transition appear in Glass documentation
  Scenario Outline: the default post functions of the workflow appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    And I click on the workflow <transition> name in the Workflow Transitions table
    And I click on the Post Functions tab
    Then the default <post functions> are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|post functions|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|Set issue status to the linked status of the destination workflow step., Add a comment to an issue if one is entered during a transition., Update change history for an issue and store the issue in the database., Re-index an issue to keep indexes in sync with the database., Fire a Generic Event event that can be processed by the listeners.|
