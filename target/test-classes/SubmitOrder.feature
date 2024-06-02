
@tag
Feature: Purchase the order from Ecommerce website 
  I want to use this template for my feature file

   Background:
   Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Login with username <name> and password <password> 
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                        | password         | productName  |
      | ansarisjdmohd3072@gmail.com |     Password0    | ZARA COAT 3  |
  
