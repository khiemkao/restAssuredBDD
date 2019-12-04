Feature: Local API - demo

  Scenario: demo GET request
    Given I prepare the "GET" request with path "posts"
    When I perform the call with query "id" value "1"
    Then I should see the "200" status code