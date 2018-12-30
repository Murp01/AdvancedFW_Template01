Feature: Products page

Scenario Outline: Validate promo code alert is visible when clicking on the special offers link
	Given user navigates to "<url>" website
	When the user click "<button>"
	
	Examples: 
	|							url				|			button				|
	|	https://www.bbc.co.uk/news/technology	| //span[@id='idcta-username']  |