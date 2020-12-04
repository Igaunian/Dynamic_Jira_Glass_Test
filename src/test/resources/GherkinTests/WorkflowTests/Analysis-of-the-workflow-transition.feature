
Feature: The analysis of the workflow transition appears in Glass documentation
  Scenario Outline: the workflow transitions appear on Glass
    Given I am on project's "<Glass documentation page>"
    When I choose the "<issue type>"
    Then the workflow transition "<analysis>" appear in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|analysis|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|Create,To Do,In Progress,In Review,Done,All,All,All,All|
      |/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Create,OPEN,Kati,HUNGRY,This way,WORKING ON IT,Finally,NOT HUNGRY,Jee...,DONE,Huh...,CLOSED|
