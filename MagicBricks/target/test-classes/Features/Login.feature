Feature: Validate PG navigation flow on MagicBricks
@PGPage
Scenario: Verify user can navigate from Rent dropdown  tp PG details page
Given the user launches the MagicBricks homepage
When the user hovers on the Rent dropdown
And the user clicks on the PG in Banglore option
Then validate title of page is visible

@BDPage
Scenario:Validate user can filter PGs by Brand
Given the user launches the MagicBricks homepage
When the user hovers on the Rent dropdown
And the user clicks on the Hostels in Bangalore option
Then verify text displayed on the page



#@GetPGList
Scenario Outline: Validate user can search PGs in different locations

Given the user launches the MagicBricks homepage
When the user hovers on the Rent dropdown
And the user clicks on the PG in Banglore option
And the user enters PG locality from sheet <sheet> and row <row>
And the user selects the city from suggestions
Then it should display PG listings in that locality

Examples:

  | sheet | row |
  | 0     | 0   |
  | 0     | 1   |
  | 0     | 2   |






