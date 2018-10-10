Feature: Testing the nav bar

  Scenario Outline: Title of your scenario outline
    Given I am on the home page
    When I click navbar <links>
    Then I verify that I am on the page <url>

    Examples: 
      | links | url |
      | Home | https://dev-caliber.revature.tech/caliber/#/vp/home |
      | ManageBatch | https://dev-caliber.revature.tech/caliber/#/vp/manage |
      | AccessBatch | https://dev-caliber.revature.tech/caliber/#/vp/assess |
      | QualityAudit | https://dev-caliber.revature.tech/caliber/#/vp/audit |
      | Panel | https://dev-caliber.revature.tech/caliber/#/vp/panels |
      | Reports | https://dev-caliber.revature.tech/caliber/#/vp/reports |
