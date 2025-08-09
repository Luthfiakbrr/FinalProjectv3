@web @smoke
Feature: Add to cart
  Scenario: Add a product to cart and validate
    Given I open demoblaze
    When I open first product detail
    And I add product to cart
    Then the product should be added
