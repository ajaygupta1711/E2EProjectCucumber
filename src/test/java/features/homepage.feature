Feature: Login into Application

  Scenario: Positive Test Validating Login
    Given Initialize the browser with chrome
    And Navigate to *QAClickAcademy* site
    And Click on Login link in homw page to land on signin page
    When User enters "test99@gmail.com" and "123456" and logs in
    Then Verify the user is successfully logged in
