Feature: Handling Alert Prompt with Try-Catch in Selenium
  Scenario: User handles an alert prompt using try-catch
    Given User is on the Alerts page
    When User clicks on the "Alert with Textbox" button
    Then User should see an alert prompt with message "Please enter your name"
    When User handles the alert prompt using try-catch
    Then User should see the alert prompt dismissed
