Feature: Login

  @invalid-login
  Scenario: Login using invalid username and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage
    And user see error message

  @valid-login
  Scenario: Login using valid username and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage