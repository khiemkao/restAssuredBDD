Feature: Local API - demo

  Scenario: demo GET request
    Given I prepare the "GET" request with path "products"
    When I perform the call with query "id" value "4"
    Then I should see the "200" status code