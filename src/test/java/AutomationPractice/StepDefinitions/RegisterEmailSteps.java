package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.*;
import AutomationPractice.Utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterEmailSteps {

    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;

    @Given("^User is on the home page$")
    public void verifyUserIsOnHomePage() {
        homePage=new HomePage();
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @When("^User selects SignIn link$")
    public void selectSignInLink() {
        Assert.assertTrue(homePage.isLoginButtonDisplayed());
        homePage.clickLoginBtn();
    }

    @When("^User enter email as \"([^\"]*)\"$")
    public void enterCredentials(String email) {
        loginPage.enterRegistrationEmail(email);
    }

    @Then("^User should see registration form$")
    public void verifyUserIsOnRegistrationpage() {
        loginPage=new LoginPage();
        Assert.assertTrue(loginPage.isRegistrationFormDisplayed());
    }

    @Then("^User should be able to register successfully$")
    public void isUserEmailRegistered() {

    }
    @Then("^User should not be able to register successfully$")
    public void isUserEmailRegUnsucessfull() {
        Assert.assertTrue(loginPage.isAccErrorDisplayed());
    }

    @And("^User clicks create an account button$")
    public void clickCreateAccountBtn() {
       loginPage.clickCreateBtn();
    }

    @And("^User should see full registration form$")
    public void isAccountCreationFormDisplayed() {
        registerPage=new RegisterPage();
        Utils.wait(15);
        registerPage.isRegistrationFormDisplayed();
    }

    @And("^User should see account creation error message as \"([^\"]*)\"$")
    public void verifyErrorMessage(String errorMsg) {
        Assert.assertEquals(errorMsg,loginPage.getRegErrorMsg());
    }

}

