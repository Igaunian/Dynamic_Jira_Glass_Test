
Feature: The 3rd party post functions of the workflow transition appear in Glass documentation
  Scenario Outline: the custom post functions of the workflow appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    Then the "<transition>" third party post functions "<post functions>" are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|post functions|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Finally|Adds the text WTF - This is the text to be added to the comment. as PREFIX to the entered transition-comment.|
