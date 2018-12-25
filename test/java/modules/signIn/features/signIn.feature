# Created by pact at 2018/9/7
Feature:SignIn Module
  In order to check sign in function
  As a user for DevOps app
  I want to see the sign module work well

  @acceptance @live

  Scenario Outline: Sign in test
     Given open the new DevOps app sign in page and try to sign in with the <url> URL

#    When the user access the DevOps app sign in page with below parameter:
#      | Parameter          | Scenario_data   |
#      | username           | <username>        |
#      | password           | <password>        |
#      | verificationcode  | <verificationcode>|
#    Then sign-in module should work as expected
#
#    Examples:
#      | username | password | verificationcode |
#      | admin   | 123456  | 55555           |
   Then sign into DevOps system and go to the first page

    Examples:
      | url                                   |
      | http://localhost:8080/login      |