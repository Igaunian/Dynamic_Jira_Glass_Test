
Feature: The validators of the workflow transition appear in Glass documentation
  Scenario Outline: the workflow conditions appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    And I click on the "<transition>" Validators tab
    Then the "<transition>" validators "<validators>" are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|validators|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|Only users with Administer Projects permission can execute this transition.|
