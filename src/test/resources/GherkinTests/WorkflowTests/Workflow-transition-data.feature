
Feature: The workflow transition data appear in Glass documentation
  Scenario Outline: the workflow transition data appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    Then the workflow <transition>'s <data> appear in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|transition|data|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|To Do|To Do, All, Global, -, -, -, Default 5, Custom 1|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|This Way|This way, HUNGRY, Unique, Workflow Screen, 2, 1, Default 5, Custom 1|
