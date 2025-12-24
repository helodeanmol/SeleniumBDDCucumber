@login_smoke

Feature: Login functionality

  Scenario: Valid login
    Given user is on login page
    When user enters valid credentials
    Then user should be logged in

  Scenario: Logout
    Given user is logged in
    When user clicks on logout button
    Then user should be logged out
