Feature: validate MagicBricks website launch functionality

Scenario:
Verify MagicBricks Homepage lauch successfully

Given User launches the application with configured url
When User waits until the homepage is fully loaded
Then Homepage should be displayed successfully
And the application title should be displayed

      
 @scenario
 Scenario:To navigate to Interior Designers in Hyderabad
  Given user on the homepage
  When user hover on Home Interiors dropdown 
  And user click Home interior Design services
  #Then user nagivate to Home interior Design services page
  When user click on hyderabad 
  Then user navigate to Interior Designers in Hyderabad page.
  
 

 
 