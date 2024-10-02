
@tag
Feature: Error validation
  I want to use this template for my feature file
  
  @Errorvalidation
  Scenario Outline: Title of your scenario outline
    Given I landed on the Ecommerce page
    And Logged in with username<name> and password<password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      |name  						 	 |password    |
      |madhavan28@gmail.com|123				  |
      
	