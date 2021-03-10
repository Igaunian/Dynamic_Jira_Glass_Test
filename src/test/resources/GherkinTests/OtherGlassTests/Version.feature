Feature: The version appears in Glass documentation
  Scenario Outline: the version appears on Glass
    And I am on project's "<Versions page>"
    And I am on project's "<Glass documentation page>"
    Then the "<version name>" appears on Versions page and on the Glass documentation page

    Examples:
      |Versions page|Glass documentation page|version name|
      |https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.atlassian.jira.jira-projects-plugin%3Arelease-page&status=unreleased|https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.atlassian.jira.jira-projects-plugin%3Arelease-page&status=unreleased|HelloWorld|
