Feature: The permissions editing link works in Glass documentation
  Scenario Outline: the editing link works on Glass
    Given I am logged in as a "<user>"
    And I am on project's "<Glass documentation page>"
    When I click on the Permissions tab
    And I click on the link next to the Permission Matrix headline
    Then the "<editing page>" for project permissions opens

    Examples:
      |user|Glass documentation page|editing page|
      |codecooladmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/JGDTP/permissions|
