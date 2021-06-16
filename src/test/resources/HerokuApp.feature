@run
  Feature: HerokuApp
    Scenario: Login
      Given I am on HerokuApp login page
      When I enter "tomsmith" in username field
      And I enter "SuperSecretPassword!" in password field
      And I click on login button
      Then I am logged in

      Scenario: Logout
        Given I am on Loginpage
        When I click Logout
        And I enter "<string>" in password field
