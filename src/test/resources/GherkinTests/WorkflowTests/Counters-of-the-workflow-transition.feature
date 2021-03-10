
Feature: The counters of the workflow transition match in Glass documentation
  Scenario Outline: the workflow transition data appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    And I click on the workflow "<transition>" name in the Workflow Transitions table
    Then the "<transition>" "<counters>" match in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|transition|counters|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|To Do|0,0,6|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This way|2,1,6|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Finally|2,0,6|
