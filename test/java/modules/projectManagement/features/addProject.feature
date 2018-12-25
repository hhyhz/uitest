# Created by pact at 2018/11/23
Feature: Add Project
  In order to check add project function
  As a user for DevOps app
  I want to see add project work well

  @acceptance @live
  Scenario Outline: Add Project
    #Given the user status is signed in devops system
    Given open the new DevOps app sign in page and try to sign in with the <url> URL
    When the user click the add project button and input <projectName> project and repository address: <repositoryAdd> to add a project
    Then a <projectName> project will show on the project management page
    Examples:
      | url                                               | projectName     | repositoryAdd                                 |
      | http://localhost:8080/login                  | TomAutoTest   | https://github.com/hhyhz/springboot.git |