
@tag
Feature: Purachse the Order from E-commerce Website
  End to end test to purachase the Order
  
  Background: I landed on WebPage  

  @tag2
  Scenario: Positive Test of Submitting the Order
    Given Navigate to test Store Web Page
    When I Add the product to cart 
    And I click on Checkout
    Then Landed on page with title "Cart"

   
