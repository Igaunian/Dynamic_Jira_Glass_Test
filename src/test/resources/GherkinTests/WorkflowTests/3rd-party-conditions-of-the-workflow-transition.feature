
Feature: The 3rd party conditions of the workflow transition appear in Glass documentation
  Scenario Outline: the 3rd party workflow conditions appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    And I click on the "<transition>" Conditions tab
    Then the "<transition>" third party conditions "<conditions>" are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|conditions|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Jee|In the Fix Version field all versions must have the state released .|
