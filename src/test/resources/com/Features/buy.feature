Feature: Validate HomePage launch
@FirstSceanrio
Scenario: Verify that the HomePage is launched successfully
Given the user opens the configured browser
When the user navigate to the configured application URL
Then the homepage should be displayed
And the page title should be verified

@secondScenario
 Scenario: Click Buy and navigate to Villas in Bangalore
    Given I am on the MagicBricks homepage
    When I click on the Buy module
    And I click on Villa in Bangalore
    Then I should be redirected to the Villas in Bangalore listings page.
    

@cityList
Scenario Outline: User cityPage
    Given user is on cityPage
    And user enters city name from sheet <sheet> and row <row>
    When user clicks on search button
    Then it should display list of properties available

Examples:
    | sheet | row |
    | 0     | 0   |
    | 0     | 1   |
   

@fourthscenario
Scenario: User navigates to Ready-to-Move flats and clicks Post Property
  Given the user is on  the homepage 
  When the user clicks on the Buy option 
  And the user clicks on the Ready to Move
  Then the user should be navigated to Ready to move flats page
  And the user clicks on zero brokerage using 
  Then the Post Property page should be displayed successfully                                                                
    
    
@fifthscenario
Scenario Outline: User navigates to the Rates and Trends
    Given user is on the MagicBricks Home Page
    And the user clicks on the Rates and Trend
    And user enters project name from sheet <sheet> and row <row>
    When user clicks on show Trends 
    Then it should display the updated properties

Examples:
    | sheet | row |
    | 1     | 0   |
    | 1     | 1   |
    
    

@NegativeScenario
Scenario: User enters the invalid location in the search box
Given the user is on the Buy module page
When the user clicks on search box
And the user enters an invalid location
And the user click on search button
Then an error message should be displayed from the properties



    
    
    
    
    
    
    
    
    
    
    