Feature: SCM (Supply Chain Management) Journey
  Scenario: Create a new purchase order and verify inventory update
    Given user logs in to the SCM portal
    When user creates a purchase order with valid supplier and item details
    Then the purchase order should be saved
    And the inventory should be updated accordingly
