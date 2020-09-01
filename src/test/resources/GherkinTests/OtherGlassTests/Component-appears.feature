Feature: The component appears in Glass documentation
  Scenario Outline: the component appears on Glass
    Given I am on project's <Components page>
    And I am on project's <Glass documentation page>
    Then the <component name> appears on Components page and on the Glass documentation page

    Examples:
      | Components page                                                                                                          | Glass documentation page                                                                    | component name |
      | https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.atlassian.jira.jira-projects-plugin:components-page | https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass | blabla         |
