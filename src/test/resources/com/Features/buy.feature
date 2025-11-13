Feature: Validate HomePage launch
Scenario: Verify that the HomePage is launched successfully
Given the user opens the configured browser
When the user navigate to the configured application URL
Then the homepage should be displayed
And the page title should be verified


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
   

                                                                   
    
    
    
    
    
    
    
    
    
    
    
    