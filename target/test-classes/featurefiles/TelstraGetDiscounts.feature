Feature: Retrieve Discounts
  Scenario: Given a customer exists and one or more discount objects have been set up in the system
	Given a customer exists and one or more discount objects have been set up in the system UUID qa-test-user
	When a user retrieves the discount by valid UUID
	Then the status in discounts is 200
	