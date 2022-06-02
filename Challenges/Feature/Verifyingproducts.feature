Feature: VerifyProducts
 
 
Scenario: VerifyProducts
  
    Given user is on login page                 
    When provided the input parameters UserName "standard_user" and Password "secret_sauce"
    When click on login button
    And verifying the Products
  