Feature: check navigate to category page

Narrative:
As a anonymous user
I want to choose a category
So that I can get category page

Scenario: get subcategory-page
Given start-page is open
When i choose <category>
And click <subcategory>
Then page is <subcategory>

Examples:
|category|subcategory|
|Компьютерная техника|Карты памяти|
|Бижутерия и часы|Мужские часы|

Scenario: search by brand-name
Given product page is open
When I choose <name>
Then get <name> result page

Examples:
|name|
|Samsung|
|Curren|

Scenario: select first product from search
Given result page is open
When I click on search result
Then I get product page


Scenario: add product to cart
Given product page
When I click add to cart
And go to cart
Then I see product in cart

Scenario: remove product from cart
Given cart page is open
When I remove product
Then cart not contain product




