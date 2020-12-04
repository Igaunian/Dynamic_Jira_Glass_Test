
Feature: The ANY/ALL condition groups of the workflow transition appear in Glass documentation
  Scenario Outline: the ANY/ALL condition groups appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    And I click on the "<transition>" Conditions tab
    Then the "<transition>" "<condition group>" is shown in the table

    Examples:
      |Glass documentation page|issue type|transition|condition group|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|ALL|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Finally|ANY|
