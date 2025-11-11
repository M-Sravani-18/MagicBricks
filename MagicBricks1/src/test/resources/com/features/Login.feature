Feature: Validate PG navigation flow on MagicBricks
@PGPage
Scenario: Verify user can navigate from Rent dropdown to PG details page
Given the user launches the MagicBricks homepage
When the user hovers on the "Rent" dropdown
And the user clicks on the "PG in Bangalore" option
And  the user clicks on the first PG from the list
Then the PG details page should be displayed with property information

@Search
Scenario: validate user applies filters and select a pg
Given the user is on PG list page
When user applies filters based on intrest
