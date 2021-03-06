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
Feature: The Quality Audit Page
  Test as much functionality of the "Quality Audit" Page of the Caliber website as much as possible

	Background:
    Given I visit the login page
    When I enter correct credentials And I click Submit
    Then I should be logged in
  Scenario: Adding a Week
    Given I am at the Quality Audit Page
    And I can add weeks
    When I click the new week button And I click yes on the New Week dialog
    Then there should be one more week than beforehand
	Scenario: Typing feedback
		Given I am on the Quality Audit Page
		When I type "Ian is a good student" in Ians feedback box And I hit refresh
		Then the feedback box should say "Ian is a good student"
	Scenario: General Feedback
		Given I am on the Quality Audit Page And I have Week 1 selected
		When I click Positive Symbol And I type "Great Teamwork" in overall feedback And I click the Save button
		Then after I move to home before going back to Quality Audit page And then go back to Week 1, the Positive Symbol is highlighted And the overall feeback says "Great Teamwork"
