
Feature: The Show Transition Labels checkbox appears in Glass documentation
  Scenario Outline: the workflow appears on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    Then the Show Transition Labels checkbox appears above the workflow diagram

    Examples:
      |Glass documentation page|issue type|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|
