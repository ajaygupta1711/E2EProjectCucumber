Feature: Login into Application

  Scenario Outline: Positive Test Validating Login
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com" site
    And Click on Login link in homw page to land on signin page
    When User enters <username> and <password> and logs in
    Then Verify the user is successfully logged in
		And Close browsers
		
Examples:
|username              |password			|
|test99@gmail.com			 |123456				|
|test123@gmail.com		 |12345				  |