Feature: Home page load verification
@HOMEPAGE
Scenario: Verify that homepage loads successfully
Given the user lauches the browser
When the user navigates to the application URL 
Then the homepage should load successfully
And the application title should be displayed
And the plot is displayed
And the plot is clickable
When user click on the Plots in Gated Community

@Plot
Scenario: Navigate to East Facing Plot
Given user on the Homepage
Then click on plot
Then It displays presenting plots and lands in Bangalore
When user clicks on East Facing Plots Explore button
Then user goes to the East Facing Plots listing page
And select on the New projects
Then New projects page is loaded

@Search
Scenario: Entering datain the search bar and navigating to poperty details
Given the user is on the Homepage of the magicBricks
When the user clicks on the plot option
And enters the search data in the search bar
And clicks on the search button

@scenariooutlinefromexcel
Scenario: Select budget from Excel2
Given the user on the Homepage
And enter budget in the budget box <row> <sheet>

Examples:
  | row | sheet |
  | 1   | 0     |
  | 2   | 0     |



        