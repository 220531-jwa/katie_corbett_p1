Feature: Change request status
  Background:
    Given a Finance Manager is on the Change Request Status page
  Scenario Outline: the Finance Manager changes the Request Status
    When the Finance Manager enters the "<requestid>", "<userid>", and "<status>" and clicks the submit button
    Then the Finance Manager sees a message of Success

    Examples:
    |requestid|userid|status|
    |2        |2     |5     |
    |4        |3     |1     |