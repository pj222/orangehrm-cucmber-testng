Feature: Login

Scenario: valid login
    Given user is on portal
    When user puts correct username "Admin" and pwd "admin123"
    And clicks login button
    Then home page opens
   
 