@ecommerce_E2E

Feature: E-commerce Purchase Flow
  Scenario: End-to-end journey for purchasing a product
    Given user is on the ecommerce home page
    When user logs in with valid credentials
    And user searches for a product
    And user adds the product to cart and checks out
    And user makes payment
    Then order confirmation should be displayed
    And order details should be saved in the database
