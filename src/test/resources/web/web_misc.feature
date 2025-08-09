@web
Feature: Misc web scenarios
  Scenario: Navigate to cart page
    Given I open demoblaze
    When I open first product detail
    Then the product should be added
