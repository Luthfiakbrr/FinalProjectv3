@web @e2e
Feature: End-to-end purchase flow
  Scenario: user buys a product successfully and checks out
    Given I open demoblaze
    When I open first product detail
    And I add product to cart
    And I have an item in cart
    And I place an order with checkout info
    Then I should see a purchase confirmation
