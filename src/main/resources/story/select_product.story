Feature: check select concrete product

Narrative:
As a anonymous user
I want click on search result
So that I can get product page

Scenario: select first product from search
!--Given Search result page
When I click on search result
Then I get appropriate product page