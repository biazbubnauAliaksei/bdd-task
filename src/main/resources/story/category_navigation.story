Feature: check navigate to category page

Narrative:
As a anonymous user
I want to choose a category
So that I can get category page

Scenario: get subcategory-page
Given start-page is open
When i choose Computer & Office
And click SSD
Then subcategory page is open

