Feature: Purchase Product	
  Scenario: if I try to purchase a product from the store using an invalid discount
	Given a customer exists with an UUID qa-test-user
	When Purchase Product API is called with a valid customer UUID qa-test-user with productId sku-555555555 with discount 50-percent-off"
	Then the status in failed is 400

Scenario: I want to successfully purchase a product from the store using a valid discount 
		Given a customer exists with UUID qa-test-user and has at least one discount that can be used with productId sku-1234567890
		When the user UUID qa-test-user retrieves their eligible discountId 50-percent-off
		And they have chosen a discountId 50-percent-off that is valid for product sku-1234567890
		When the Purchase Product API is called with a valid customer UUID, productId sku-1234567890 and a valid discountId for this product
		Then the status in products is 201