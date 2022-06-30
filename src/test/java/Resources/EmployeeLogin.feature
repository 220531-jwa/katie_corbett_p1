Feature: An employee can log in.
  Scenario: An employee can log in
    Given the employee is on the login page
    When the employee enters their correct credentials
    Then the employee is taken to the employee homepage
