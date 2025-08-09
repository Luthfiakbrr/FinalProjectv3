@api
Feature: Tag API
  Scenario: Get list of tags
    When I get list of tags
    Then tags response is ok
