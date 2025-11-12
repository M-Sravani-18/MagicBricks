Feature: validate MagicBricks website launch functionality
#@swc
Scenario:
Verify MagicBricks Homepage lauch successfully
Given User launches the application with configured url
When User waits until the homepage is fully loaded
Then Homepage should be displayed successfully
And the application title should be displayed

      
 #@sec1
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
 
 Scenario Outline: Verify filter by using excel
 Given user lands on the homepage
 When user is hover on the Home Interiors dropdown
 And user click on  Home interior Design in banglore
 And user click on dropdown 
 And select city from <sheet> and <row>
 Then page should loaded as option selected
 
 Examples:
| sheet | row|
| 0     | 1   |
| 0     | 2  |

 
 