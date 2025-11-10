@HomePage
Feature: Validate HomePage launch
Scenario: Verify that the HomePage is launched successfully
Given the user opens the configured browser
When the user navigate to the configured application URL
Then the homepage should be displayed
And the page title should be verified

@Buy
Scenario: Verify that the villas for sale in Banglore page is open
When the user clicks on the "Buy" option
And the user selects "Villa in Banglore" from the dropdown
Then the villas for Sale page should be displayed
And the page title should contain "Villas for sale in Banglore"
And the user should see a list of villa properties displayed




