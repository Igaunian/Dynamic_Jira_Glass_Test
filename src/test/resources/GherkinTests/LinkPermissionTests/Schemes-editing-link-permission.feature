Feature: The schemes editing link works according to the permissions in Glass documentation
  Scenario Outline: the editing link works according to the permissions on Glass
    Given I am logged in as a <user>
    And I am on project's <Glass documentation page>
    When I click on the Schemes tab
    Then there <is / is not> the editing link icon next to the Schemes headline

    Examples:
      |user|Glass documentation page|is / is not|
      |codecooladmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|is|
      |jirachiprojectadmin|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|is|
      |jirachidumbuser|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass|is not|
