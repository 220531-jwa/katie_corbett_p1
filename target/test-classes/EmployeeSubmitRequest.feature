Feature: Submitting requests
  Background:
    Given an Employee is on the Submit Requests page
  Scenario Outline: the Employee can submit a request
    When the Employee enters their "<userid>" and their "<firstname>" and their "<lastname>" and their "<date>" and their "<time>" and their "<type>" and their "<description>" and their "<cost>" and their "<justification>" and their "<gradetype>" and clicks the Submit button
    Then the Employee should see the Successful Submit message

    Examples:
    |userid|firstname|lastname|date    |time   |type|description      |cost|justification|gradetype|
    |7     |Veth     |Brenatto|7/3/2022|4:46 PM|5   |Crossbow Training|30  |Better aim   |1        |
    |5     |Caduceus |Clay    |7/3/2022|4:48 PM|6   |Tea Preparation  |20  |Tea          |1        |