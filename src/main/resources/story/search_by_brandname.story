Feature: check search by brandname

Narrative:
As a anonymous user
I want to perform search by brand-name
So that I can get search result page

Scenario: search by brand-name

GivenStories: category_navigation.story
Given get
When I choose Samsung
Then get Samsung result page