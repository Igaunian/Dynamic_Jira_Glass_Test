Feature: The issue types appear in Glass documentation
  Scenario Outline: the issue types appear on Glass
    Given I am on project´s Settings "<Issue types page>"
    And I am on project's "<Glass documentation page>"
    Then the "<issue type names>" appear on Issue types page and on the Glass documentation page in the Issue Types tab

    Examples:
      | Issue types page                                                                     | Glass documentation page                                                                    | issue type names                                    |
      | https://jira2.codecool.codecanvas.hu/plugins/servlet/project-config/JGDTP/issuetypes | https://jira2.codecool.codecanvas.hu/projects/JGDTP?selectedItem=com.codecanvas.glass:glass | Improvement, Task, Sub-Task, New Feature, Bug, Epic |
