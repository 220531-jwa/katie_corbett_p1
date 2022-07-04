Feature: Changing a grade
  Background:
    Given an Employee is on the Update Request page
  Scenario Outline: an Employee adds their proof
    When the Employee enters their "<requestid>" and their "<userid>" and their "<proof>" and clicks Submit Changes
    Then the Employee sees the Success message

    Examples:
    |requestid|userid|proof|
    |2        |2     |pass |
    |6        |6     |pass |