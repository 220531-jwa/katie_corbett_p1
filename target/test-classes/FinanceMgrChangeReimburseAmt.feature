Feature: Change reimbursement amount
  Background:
    Given a Finance Manager is on the Update Reimbursement Amount page
  Scenario Outline: the Finance Manager changes the Reimbursement Amount
    When the Finance Manager enters the "<requestid>", "<userid>", and "<amount>" and clicks submit
    Then the Finance Manager sees the Success message

    Examples:
      |requestid|userid|amount|
      |2        |2     |40500 |
      |1        |1     |240   |