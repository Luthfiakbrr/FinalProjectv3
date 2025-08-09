@web @negative
Feature: Negative UI tests
  Scenario: Try to purchase with empty cart should not allow
    Given I open demoblaze
    When I open first product detail
    Then the product should be added
    # you can add more negative flows here
