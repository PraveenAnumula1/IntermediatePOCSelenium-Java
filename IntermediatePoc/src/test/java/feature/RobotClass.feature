Feature: Perform Robot Actions on Web Page
  Scenario: Perform Robot Actions
    Given I open the Facebook login page
    And maximize the browser window
    When I perform mouse actions
    Then verify the actions are performed successfully