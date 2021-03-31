
Feature: DemoQA - Book Store Application Page
  Background:
    Given I am on the "Home" page
    And   I click "Book Store Application"
    Then  I am on the "Book Store Application" page

  @run
  Scenario: Login
    When I click "Login option"
    And  I click "New User button"
    And  I set "First Name field" to "Marcis"
    And  I set "Last Name field" to "KK"
    And  I set "UserName field" to "marcis111"
    And  I set "Password" to "Aa@1234567"
    And  I click "I'm not robot button"
    And  I click "Register button"
    And  I click "Confirm Alert button"
    Then "Confirm Alert" should contain "User Register Successfully"

