# Created by pact at 2018/11/1
Feature: Check Project Build
  In order to check project build  history function
  As a user for DevOps app
  I want to see project build history function work well

  @acceptance @live @test
  Scenario Outline: Check Project Build History
    #Given the user status is signed in devops system
    Given open the new DevOps app sign in page and try to sign in with the <url> URL
    Then show project pipeline on build management page

    Examples:
      | url                                   |
      | http://localhost:8080/login       |