@regression
Feature: Login feature for www.automationpractice.com
  As a registered user
  I want to see a login form
  So that I can login successfully

  #happy path scenario
  @validLogin @smoke @login
  Scenario: User can login successfully with valid credentials
    Given User is on home page
    When User clicks sign-in link
    Then User should see login form
    When User enters email address as "like@hostguru.info" and password as "like@hostguru.info"
    And User clicks sign-in button
    Then User should be logged in successfully
    And User's full name "sfsd dbhed" should be displayed in menu bar

    #un-happy path scenario
  @invalidLogin @smoke @login
  Scenario Outline: User cannot login successfully with in-valid credentials
    Given User is on home page
    When User clicks sign-in link
    Then User should see login form
    When User enters email address as "<username>" and password as "<password>"
    And User clicks sign-in button
    Then User should not be logged in successfully
    And User should see error message as "<Message>"
    Examples:
      | username            | password           | Message                                         |
      #incomplete fields----------------------------------------------------------------------------
      |                     |                    | An email address required. |
      |                     | like@hostguru.info | An email address required. |
      | like@hostguru.info  |                    | Password is required.      |
      #valid email and invalid password--------------------------------------------------------------
      | like@hostguru.info  |   type123          | Authentication failed.     |
      #email format incorrect-----------------------------------------------------------------------
      | like@hostguru       |   type123          | Invalid email address.     |
      #password format incorrect--------------------------------------------------------------------
      | like@hostguru.info  |   123              | Invalid password.          |
      #account does not exist-----------------------------------------------------------------------
      | 123@test.test       |   type123          | Authentication failed.     |
