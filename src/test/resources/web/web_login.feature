@web @login
Feature: Login tests
  Scenario: Successful login modal
    Given I open login modal
    When I login with username "validUser" and password "validPass"
    Then I should see the logged in username

  Scenario: Invalid credentials
    Given I open login modal
    When I login with username "wrong" and password "bad"
    Then I should see login error alert
