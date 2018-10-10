#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Test color faces

  @tag1
  Scenario: Clicking on the question mark
    Given I am on the caliberbot 10-1-18 assess page
    When I click on the red question mark
   
    Then the red question mark changes to a blue star
    @tag2
    Scenario: Clicking on the blue star
    Given I am on the caliberbot 10-1-18 assess page
    When I click on the blue star
   
    Then the blue star changes to a green face
    @tag3
    Scenario: Clicking on the green face
    Given I am on the caliberbot 10-1-18 assess page
    When I click on the green face
   
    Then the green face changes to a yellow face
    @tag4
    Scenario: Clicking on the yellow face
    Given I am on the caliberbot 10-1-18 assess page
    When I click on the yellow face
   
    Then the yellow face changes to a red face
    @tag5
    Scenario: Clicking on the red face
    Given I am on the caliberbot 10-1-18 assess page
    When I click on the red face
   
    Then the red face changes to a question mark
    

 