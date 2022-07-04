Feature: User login
  Background:
    Given an Employee is on the login page
  Scenario Outline: The Employee can log in with their credentials
    When the Employee types in their "<username>" and "<password>" and clicks the Login button
    Then the Employee should be on the Employee Homepage

    Examples:
    |username       |password |
    |beaulionettm9  |thaddeus |
    |yashanydoorinm9|stormlord|
    |jesterlavorrem9|sprinkle |