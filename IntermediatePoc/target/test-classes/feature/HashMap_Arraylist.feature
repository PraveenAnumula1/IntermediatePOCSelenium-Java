Feature: Adding items to cart
  Scenario: Add items to cart
    Given User is on the inventory page
    When User logs in with valid credentials
    Then User adds specified items to the cart
