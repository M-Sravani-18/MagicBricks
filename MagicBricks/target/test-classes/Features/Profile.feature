Feature: validate MagicBricks website launch functionality
@swc
Scenario:
Verify MagicBricks Homepage lauch successfully
Given User launches the application with configured url
When User waits until the homepage is fully loaded
Then Homepage should be displayed successfully
And the application title should be displayed

      
 @sec1
 Scenario: To navigate to Interior Designers in Hyderabad
  Given user on the homepage
  When user hover on Home Interiors dropdown 
  And user click Home interior Design services
  Then user nagivate to Home interior Design services page

  
  
  
#@sce2
Scenario: To navigate to Interior Designers in bangalore
  Given user is on the homepage
  When user hover on the Home Interiors dropdown 
  And user click Home interior Design in banglore
  Then user nagivate to Home interior Design in banglore page
  #And user click on Get Estimate Now
 #Then  navigate toSelect your BHK type 
 
@sec3
Scenario: verify properties
Given user lands on home page
When user clicks on the Commercial
And user enters city name from sheet <sheet> and row <row>
And user clicks on search button
Then it shoiuld display list of properties available
Examples:
|sheet | row|
|0     | 0 |
|0     | 1 |



@scenario4
Scenario: To verify contact now
Given user is on The Homepage
When user hovers on the Home Interiors dropdown 
And user click Home interior Design in banglore
And user click the contact
Then user navigate to Please share your contact details page



 
 