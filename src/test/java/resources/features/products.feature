Feature: Products page

Scenario Outline: Validate promo code alert is visible when clicking on the special offers link
	Given user navigates to "<url>" website
	When the user click "<button>"
	Then the user will be presented with a promo alert
	
	Examples: 
	|							url										|			button				|
	|	http://webdriveruniversity.com/Page-Object-Model/products.html	| container-special-offers .sub-heading |