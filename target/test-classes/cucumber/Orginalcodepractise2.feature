
@tag
Feature: Purchase order from ecommerce practise
  
  Background:
  Given I landed on the Ecommerce page

  @Regression
  Scenario Outline: Positive test of purchase the order
    Given Logged in with username<name> and password<password>
    When I add the product <productname> to cart
    And Checkout<productname> and submit the order
    Then "Thankyou for the order." is displayed on the confirmation page

    Examples: 
      |name  						 |password    |productname    |
      |madhavan@gmail.com|Madhavan@28 |ADIDAS ORIGINAL|
      |bm@gmail.com      |Stonecold@0	|IPHONE 13 PRO	|