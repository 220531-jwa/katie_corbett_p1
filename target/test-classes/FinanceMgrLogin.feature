Feature: User login
  Background:
    Given a Finance Manager is on the login page
  Scenario Outline: The Finance Manager can log in with their credentials
    When the Finance Manager types in their "<username>" and "<password>" and clicks the Login button
    Then the Finance Manager should be on the Finance Manager Homepage

    Examples:
      |username     |password  |
      |thetraveler  |chaos     |
      |pumatsol     |vagrant   |
      |orlyskiffback|navigator |