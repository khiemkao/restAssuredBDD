@Products
Feature: Products - GET - "/products"

  Background:
    Given I prepare the "GET" request with path "/products"
    And I set up the OAuth2 token with "validUser"

  Scenario Outline: Validate returning the <statusCode> status code when calling with <testData>
    When I perform the productions call with query params as "<testData>"
    Then I should see the "<statusCode>" status code
    Examples:
      | statusCode | testData          |
      | 200        | validProduct      |
      | 200        | productWithId     |
      | 200        | productWithIdName |
    
    Scenario: Validate returning the corresponding detail information
      When I perform the productions call with query params as "validProduct"
      Then I should see the detail information of "validProduct"