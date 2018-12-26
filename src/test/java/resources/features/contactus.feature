Feature: submite data to webdriveruniversity.com using data from contact us form

Scenario: Submit valid data via the contact us form
	Given I access webdriveruniversity contact us form
	When I enter a valid firstname
	When I enter a valid lastname
	| Woods | Jackson | Jones |
	And I enter a valid email address
	And I enter comments
	| example comment 01 | example comment 02 |
	When I click on the submit button
	Then the information will successfully be submitted via the contact us form