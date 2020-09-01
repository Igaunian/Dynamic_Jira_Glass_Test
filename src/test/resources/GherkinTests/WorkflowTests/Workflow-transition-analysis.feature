
Feature: The workflow transition analysis appears in Glass documentation
  Scenario Outline: the workflow transitions appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    Then the workflow <transitions> appear in the Workflow Transitions table

    Examples:
      |Glass documentation page|issue type|transitions|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|Create, To Do, In Progress, In Review, Done|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Create, Kati, This way, Finally, Jee..., Huh...|
