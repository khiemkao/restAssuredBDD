@Stores
Feature: Stores - "/stores"

  Scenario Outline: Validate returning the <statusCode> status code when calling API with <testData>
    Given I prepare the "POST" request with path "/stores"
    And I set up the OAuth2 token with "validUser"
    When I perform the stores call with body as "<testData>"
    Then I should see the "<statusCode>" status code
    Examples:
      | statusCode | testData        |
      | 201        | newStore      |
      | 500        | duplicatedStore |

  Scenario Outline: Validate returning the <statusCode> status code when calling API with <testData>
    Given I prepare the "GET" request with path "/stores"
    And I set up the OAuth2 token with "validUser"
    When I perform the stores call with query params as "<testData>"
    Then I should see the "<statusCode>" status code
    Examples:
      | statusCode | testData       |
      | 200        | queryById      |
      | 200        | queryByName    |
      | 200        | queryByIdName  |
      | 200        | queryByAddress |

  Scenario: Validate automatic generating the id when creating a new store
    Given I prepare the "POST" request with path "/stores"
    And I set up the OAuth2 token with "validUser"
    When I perform the stores call with body as "newStore"
    Then I should see the id property returning with value

  Scenario: Validate returning the corresponding store information
    Given I prepare the "GET" request with path "/stores"
    And I set up the OAuth2 token with "validUser"
    When I perform the stores call with query params as "queryByIdName"
    Then I should see the store information of "validStore"