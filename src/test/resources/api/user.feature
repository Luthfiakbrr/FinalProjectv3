@api
Feature: User API - CRUD and negative tests
  Scenario: Create, get and delete user (happy path)
    When I create user with firstName "Luthfi" and email "luthfi@example.com"
    Then create should be successful
    When I get user by created id
    Then get user should return ok
    When I delete user by created id
    Then delete should be successful

  Scenario: Create user with invalid body (negative)
    When I create user with firstName "" and email "not-an-email"
    Then create should be successful

  Scenario: Get user with invalid id
    When I get user by invalid id "invalid-id-123"
    Then response should be not found
