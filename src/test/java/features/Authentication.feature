@Authentication
Feature: Authentication - POST - "/auth/login"

  Background:
    Given I prepare the "POST" request with path "/auth/login"

  Scenario Outline: Validate returning the <statusCode> status code when calling with <testUser>
    When I perform the authentication call with body as "<testUser>"
    Then I should see the "<statusCode>" status code
    Examples:
      | testUser            | statusCode |
      | validUser           | 200        |
      | blankUser           | 401        |
      | blankEmailUser      | 401        |
      | blankPasswordUser   | 401        |
      | invalidPasswordUser | 401        |
      | notExistUser        | 401        |
      | lackingAll          | 401        |
      | lackingPassword     | 401        |
      | lackingEmail        | 401        |

  Scenario: Validate returning the access token when success
    When I perform the authentication call with body as "validUser"
    And I should see the access token

  Scenario Outline: Validate returning the error message when not success with <testUser>
    When I perform the authentication call with body as "<testUser>"
    Then I should see the error message as "Incorrect email or password"
    Examples:
      | testUser            |
      | blankUser           |
      | blankEmailUser      |
      | blankPasswordUser   |
      | invalidPasswordUser |
      | notExistUser        |
      | lackingAll          |
      | lackingPassword     |
      | lackingEmail        |