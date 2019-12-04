Feature: Local API - demo

  Scenario: demo POST request
    Given I prepare the POST request with path "posts"
    When I perform the call with path params "1"
    Then I should see the "201" status code