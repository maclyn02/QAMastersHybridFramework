@regression
Feature: Email Registration feature for www.automationpractice.com
  As a new user
  I want to see a registration form
  So that I can register my e-mail address

  #happy path scenario
  @validEmail @smoke @register
  Scenario: User can register with valid email address
    Given User is on the home page
    When User selects SignIn link
    Then User should see registration form
    When User enter email as "like1@hostguru.info"
    And User clicks create an account button
    Then User should be able to register successfully
    And User should see full registration form

    #un-happy path scenario
  @invalidEmail @smoke @register
  Scenario Outline: User cannot register with in-valid email address
    Given User is on the home page
    When User selects SignIn link
    Then User should see registration form
    When User enter email as "<email>"
    And User clicks create an account button
    Then User should not be able to register successfully
    And User should see account creation error message as "<Message>"
    Examples:
      | email               | Message                                                                                                                   |
      #incomplete field----------------------------------------------------------------------------------------------------------------------------------
      |                     | Invalid email address.                                                                                                    |
      #email address for existing account----------------------------------------------------------------------------------------------------------------
      | like@hostguru.info  | An account using this email address has already been registered. Please enter a valid password or request a new one.      |
      #invalid email format------------------------------------------------------------------------------------------------------------------------------
      | like@hostguru       | Invalid email address.                                                                                                    |
      | like.info           | Invalid email address.                                                                                                    |
      | likehostguruinfo    | Invalid email address.                                                                                                    |
