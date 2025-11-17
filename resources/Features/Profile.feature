Feature: validate MagicBricks website launch functionality
#@swc
#Scenario: Verify MagicBricks Homepage lauch successfully
#Given User launches the application with configured url
#When User waits until the homepage is fully loaded
#Then Homepage should be displayed successfully
#And the application title should be displayed

      
 @scenario1
 Scenario: To navigate to Interior Designers in Hyderabad
  Given user on the homepage
  When user hover on Home Interiors dropdown 
  And user click Home interior Design services
  Then user nagivate to Home interior Design services page
	
    
@scenario2
Scenario: To navigate to Interior Designers in bangalore
  Given user is on the homepage
  When user hover on the Home Interiors dropdown 
  And user click Home interior Design in banglore
  Then user nagivate to Home interior Design in banglore page
  #And user click on Get Estimate Now
 #Then  navigate toSelect your BHK type 
 
@scenario3
Scenario Outline: verify properties
Given user lands on home page
When user clicks on the Commercial
And user enters city name from sheet <sheet> and row <row>
And user clicks on search button
Then it shoiuld display list of properties available
Examples:
|sheet | row|
|0     | 0 |
|0     | 1 |



#@scenario4
#Scenario: To verify contact now
#Given user is on The Homepage
#When user hovers on the Home Interiors dropdown 
#And user clicks  interior Designers in banglore
#And user click the contact
#Then user navigate to Please share your contact details page

@scenario4
Scenario: to verify the propertyworth
Given user is on The HomePage
When user hover on the MB Advice dropdown
And user clicks on Prop Index
#And user clicks on Get Estimate
Then user navigate to propworth page


@scenario5
Scenario Outline: verify rates and trends
Given user is on the homepage
When user clicks on the commerical
And the user clicks on the rates and trends
And user enters the locality name from sheet <sheet1> and row <row1>
And user cliks on show trends
Then it displays the updated page

Examples:
| sheet1 | row1 |
|   1    |   0  |
|   1    |   1  |  


@scenario6
Scenario:
Given user on the magicbricks homepage
When user cliks on the the commercialtab
And enter the invalid cityname 
And click on search 
Then error message should diplay
 