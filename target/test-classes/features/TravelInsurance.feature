@travelInsurance_E2E

Feature: Travel Insurance Sales Journey
  Scenario: End-to-end journey for purchasing travel insurance
    Given user launches the travel insurance site
    When user logs in with valid credentials
    And user navigates to the quotation page
    And user fills travel details and requests a quote
    And user enters personal details
    And user proceeds to make the payment
    Then policy should be created and acknowledgement should be shown
    And all journey details should be stored in the database
