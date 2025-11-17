Feature: Home page load verification
@Scenario1
Scenario: Verify that homepage loads successfully
Given the user lauches the browser
When the user navigates to the application URL 
Then the homepage should load successfully
And the application title should be displayed
And the plot is displayed
And the plot is clickable
Then user click on the Plots in Gated Community

@Scenario2
Scenario: Navigate to East Facing Plot
Given user on the Homepage
Then click on plot
Then It displays presenting plots and lands in Bangalore
When user clicks on East Facing Plots Explore button
Then user goes to the East Facing Plots listing page
And select on the New projects
Then New projects page is loaded

@Scenario3
Scenario: Navigate to See Plots from Investment Corridor
Given the user is on the Homepage of the magicBricks
When the user clicks on the plot option
And click on the see plots1
Then navigate to the plots page and click click on the seeplots2


@Scenario4
Scenario: Select city from the Excel Sheet
Given the user on the Homepage
When the user clicks on the plot option
Then  enter the city in the search box <row> <sheet>

Examples:
  | row | sheet |
  | 1   | 0     |
  | 2   | 0     |
  

@Scenario5
Scenario: Validate budget functionality in plot
Given user is on the home page
And the user clicks on plot
And user clicks Budget 
And the user reads price from the excel sheet <sheet> <row>
And click on search
Then result is displayed

Examples:
  | row | sheet |
  | 1   | 0     |
  | 2   | 0     |







        