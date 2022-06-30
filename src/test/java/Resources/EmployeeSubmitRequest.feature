Feature: An employee can submit a reimbursement request
  Scenario: An employee is submitting a reimbursement request
  Given the employee is on the submit page
  When the employee enters all information and hits "Submit"
  Then the webpage shows the request in a table