Feature: add product to cart

Narrative:
As a anonymous user
I want to add product to cart
So product will be located in cart

Scenario: add product to cart
!--Given product page
When I click add to cart
And go to cart
Then I see product in cart