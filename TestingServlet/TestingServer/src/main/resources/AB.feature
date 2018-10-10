Feature: Year testing on Assess Batch Page

	Background:


  Scenario Outline: 
  Given User is at Assess Batch Page
  When User selects "<year>" from the year tab
  Then The "<selectedyear>" information is accessible
  
  Examples:
  | year | selectedyear |
  | 2019 | 2019 |
  | 2018 | 2018 |
  | 2017 | 2017 |
  | 2016 | 2016 |