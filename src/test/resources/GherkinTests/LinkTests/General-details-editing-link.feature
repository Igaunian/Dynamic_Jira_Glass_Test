Feature: The general details editing link works in Glass documentation
  Scenario Outline: the editing link works on Glass
    Given I am logged in as a "<user>"
    And I am on project's "<Glass documentation page>"
    When I click on the link next to the Basic Summary
    Then the "<editing page>" for project details opens

    Examples:
      |user|Glass documentation page|editing page|
      |codecooladmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|https://jira2.codecool.codecanvas.hu/secure/project/EditProject!default.jspa?pid=10104|
