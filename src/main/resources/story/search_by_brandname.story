Feature: check search by brandname

Narrative:
As a anonymous user
I want to perform search by brand-name
So that I can get search result page

Scenario: search by brand-name
Given subcategory page
When I choose brand-name
Then get search result page