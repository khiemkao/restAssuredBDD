@Products
Feature: Products - "/products"

  Background:
    Given I prepare the "GET" request with path "/products"
    And I set up the OAuth2 token with "validUser"

  Scenario Outline: Validate returning the <statusCode> status code when calling API with <testData>
    When I perform the products call with query params as "<testData>"
    Then I should see the "<statusCode>" status code
    Examples:
      | statusCode | testData          |
      | 200        | validProduct      |
      | 200        | productWithId     |
      | 200        | productWithIdName |
    
    Scenario: Validate returning the corresponding product information
      When I perform the products call with query params as "validProduct"
      Then I should see the product information of "validProduct"