
Feature: The 3rd party validators of the workflow transition appear in Glass documentation
  Scenario Outline: the workflow conditions appear on Glass
    Given I am on project's <Glass documentation page>
    When I choose the <issue type>
    And I click on the workflow <transition> name in the Workflow Transitions table
    And I click on the Validators tab
    Then the <validators> are listed in the table

    Examples:
      |Glass documentation page|issue type|transition|validators|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Epic|Jee|In the Fix Version field all versions must have the state released . If not, the following text will be displaed: In the 'Fix Version' field all versions must have the state 'released' .|
