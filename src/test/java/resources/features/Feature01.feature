Feature: open BBC News and search for today

Scenario: Open BBC news homepage and search for today
	Given I access the BBC news homepage
	And I click on the searchbar
	And I enter "today" into the searchbar textfield
	When I click on the search icon
	Then the search results will retrieve results matching the "" search term
	

	
