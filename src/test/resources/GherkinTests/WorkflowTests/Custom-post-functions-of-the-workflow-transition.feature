
Feature: The custom post functions of the workflow transition appear in Glass documentation
  Scenario Outline: the custom post functions of the workflow appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    Then the "<transition>" custom "<post functions>" are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|post functions|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|The Description of the issue will be set to having a lunch.|
