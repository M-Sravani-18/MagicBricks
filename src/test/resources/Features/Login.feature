Feature: MagicBricks Navigation
@Locality
Scenario: Navigate to first locality in New Delhi
Given the user launches the MagicBricks homepage
When the user clicks on the MB Advice section
And the user selects Localities in New Delhi page
And the user clicks on the first displayed locality
Then the first locality page is displayed

@CompareLocalities
Scenario: validate locality details page contents
Given the user launches the MagicBricks homepage
When the user clicks on the MB Advice section
And the user clicks on Compare Localities
Then the compare localities should launch

@Price/sqftfilter
Scenario Outline: Validate price/sqft filter functionality on Localities in New Delhi page
Given the user launches the MagicBricks homepage
When the user clicks on the MB Advice section
And the user selects Localities in New Delhi page
And the user clicks on the Price/sqrt filter option
And the user reads Min price values from Excel sheet <Sheet> and row <Row>
And the user clicks on the Done 
Then the result is displayed 
Examples:
| Sheet | Row |
| 0 | 1 |
| 0 | 2 | 

@Searchbox
Scenario Outline: Validate Search box in Localities in New Delhi Page
Given the user launches the MagicBricks homepage
When the user clicks on the MB Advice section
And the user selects Localities in New Delhi page
And the user clicks on search box
And the user reads City from Excel sheet <Sheet> and <Row>
And the user clicks on the first displayed locality
Then the locality page displays

Examples:
 | Sheet | Row |
 | 1     | 1   |
 | 1     | 2   |




@Projects
Scenario: Validate Projects in New Delhi Page
Given the user launches the MagicBricks homepage
When the user clicks on the MB Advice section
And the user selects New Projects in New Delhi page
Then the page should be displayed


@NegativeScenario
  Scenario: User enters an invalid location in search box
    Given the user launches the MagicBricks homepage
    When the user clicks on the MB Advice section
    And the user selects Localities in New Delhi page
    And the user clicks on search box
    And the user enters an invalid location from properties
    Then an error message should be displayed from properties
   