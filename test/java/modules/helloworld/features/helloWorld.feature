# Created by pact at 2018/11/16
Feature: Hello World
  In order to check demo function
  As a user for DevOps app
  I want to see a demo for DevOps system

  @demo
  Scenario Outline: Hello World
    Given the user go to the hello world page with the <url> URL
    Then show hello world page to the user
    Examples:
      | url                                               |
      | http://47.92.238.238:9000/                    |

