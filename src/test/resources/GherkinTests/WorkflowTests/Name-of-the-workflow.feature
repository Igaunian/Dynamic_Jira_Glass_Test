
Feature: The name of the workflow appears in Glass documentation
  Scenario Outline: the workflow appears on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    Then the workflow "<name>" appears below the selected issue type's name

    Examples:
      |Glass documentation page|issue type|name|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|Software Simplified Workflow for Project JGDTP|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Jirachi|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|New Feature|Software Simplified Workflow for Project JGDTP|
