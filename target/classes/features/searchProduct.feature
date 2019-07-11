Feature: Search Product
  User want to search product using registered account

	Background: Login as user
		Given User is logged in with email "" and password ""
	
  @tag1
  Scenario: User can search item with search bar
    Given User is at homepage
    When User choose city "Bogor Kota" 
    And User input "mobil" in the search bar
    And User click search button
    Then User can see search result