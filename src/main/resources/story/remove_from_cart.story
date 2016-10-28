Feature: remove product from cart

Narrative:
As a anonymous user
I want open cart
and remove product from cart
So cart not contains product

Scenario: remove product from cart
!--Given product page
When I go to cart
And remove product
Then cart not contain product