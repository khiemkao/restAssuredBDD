@Demo
Feature: Demo data

  Scenario Outline: demo
    Given I prepare the "GET" request with path "/data"
    And I set up the OAuth2 token with "validUser"
    When I perform the data call with query params as "<testData>"
    Then I should see the "<statusCode>" status code
    And I should see the responseBody of Data
    Examples:
      | testData      | statusCode |
      | queryLanguage | 200        |
      | queryUser     | 200        |