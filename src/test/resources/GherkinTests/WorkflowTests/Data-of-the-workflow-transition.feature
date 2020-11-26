
Feature: The workflow transition data appear in Glass documentation
  Scenario Outline: the workflow transition data appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    Then the workflow "<transition data>" appear in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|transition data|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|Create,To Do,In Progress,In Review,Done|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Create,Kati,This way,Finally,Jee...,Huh...|
