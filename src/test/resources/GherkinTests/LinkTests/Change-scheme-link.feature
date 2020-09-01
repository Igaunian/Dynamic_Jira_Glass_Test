Feature: The change scheme link works in Glass documentation
  Scenario Outline: the editing link works on Glass
    Given I am logged in as a <user>
    And I am on project's <Glass documentation page>
    When I click on the Schemes tab
    And I click on the Issue Type Scheme Change icon
    Then the <editing page> for project issue type scheme opens

    Examples:
      |user|Glass documentation page|editing page|
      |codecooladmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|https://jira2.codecool.codecanvas.hu/secure/admin/SelectIssueTypeSchemeForProject!default.jspa?projectId=10104|
