Feature: Search Feature

Scenario: User is able to see search bar
	Given User is on home page
	Then  User can see search bar
 
Scenario: User is able to click on search bar
	When  User click on search bar
	Then User can see search bar is highlighted

Scenario Outline: User is able to write on search bar
	Given User has clicked on search bar AND search basr is highlighted
	When User start to write "<Search Value>" into search bar input field 
Examples:
	|Search Value|
	|Dress|
	|Pants|
	|Swaeter|

Scenario Outline: User is able to see dropdown suggestion
	Given User has written "<Search Value>" keyword in search box
	Then User can see drop down suggestion list
Examples:
	|Search Value|
	|Dress|

 