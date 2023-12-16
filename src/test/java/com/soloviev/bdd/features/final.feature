Feature: Checking Wiggle's Sign-in and Sign-up Page

  Background:
    Given I open the "https://www.wiggle.co.uk/" website

  Scenario Outline: Verifying Sign-in and Sign-up pages with different passwords
    When I navigate to the sign in page
    Then I see fields for entering email and password

    When I navigate to the sign up page
    Then I see a field for entering a password

    When I click the show password button
    Then I see the hide button tooltip
    And I enter "<Password1>" in the password field
    And I clear the entered characters
    And I enter "<Password2>" in the password field
    And I clear the entered characters

    Examples:
      | Password1 | Password2 |
      | 111111    | 222222    |

