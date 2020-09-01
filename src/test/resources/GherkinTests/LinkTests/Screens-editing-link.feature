Feature: The screens editing link works in Glass documentation
  Scenario Outline: the editing link works on Glass
    Given I am logged in as a <user>
    And I am on project's <Glass documentation page>
    When I choose the <issue type>
    And I click on the link next to the Screens headline
    Then the <editing page> for project screens opens

    Examples:
      |user|Glass documentation page|issue type|editing page|
      |codecooladmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|Bug|https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/JGDTP/screens|
