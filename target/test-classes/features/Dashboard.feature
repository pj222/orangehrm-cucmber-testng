Feature: verify upgrade link

  Background: 
    Given user is logged into the portal with username "Admin" and pwd "admin123"

  Scenario: Verify upgrade link is displayed on home page
    Then Upgrade button link is displayed

  Scenario: Verify menu list on home page
    Then menu list is displayed
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintenance |
      | Claim       |
      | Buzz        |
    And count is 12

    Scenario: Verify help link on home page
    Then help link is clickable