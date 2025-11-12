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
And the user clicks on the PG in Banglore option
And the user clicks on the Brand Filter
And the user selects on the  Brand 
Then validate the page based on text




