package AutomationPractice.StepDefinitions;

import AutomationPractice.Pages.HomePage;
import AutomationPractice.Pages.LoginPage;
import AutomationPractice.Pages.UserAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginSteps {

    public HomePage homePage;
    public LoginPage loginPage;
    public UserAccountPage userAccPage;

    @Given("^User is on home page$")
    public void verifyUserIsOnHomePage() {
        homePage = new HomePage();
        Assert.assertTrue(homePage.isUserOnHomePage());
    }

    @When("^User clicks sign-in link$")
    public void clickSignInLink() {
        homePage.clickLoginBtn();
    }

    @When("^User enters email address as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void enterLoginCredentials(String email, String password) {
        loginPage.enterCredentials(email,password);
    }

    @Then("^User should see login form$")
    public void verifyLoginFormVisible() {
        loginPage=new LoginPage();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }

    @Then("^User should be logged in successfully$")
    public void isUserLoggedIn() {
        userAccPage=new UserAccountPage();
        Assert.assertTrue(userAccPage.isAccInfoDisplayed());
    }

    @And("^User clicks sign-in button$")
    public void selectSignIn() {
        loginPage.clickLoginBtn();
    }

    @And("^User's full name \"([^\"]*)\" should be displayed in menu bar$")
    public void user_should_see_his_name_as_something(String userName) {
        Assert.assertEquals(userName,homePage.getAccountName());
    }

    @Then("^User should not be logged in successfully$")
    public void verifyLoginFailure(){
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        Assert.assertTrue(loginPage.isUserOnLoginPage());
    }
    @And("^User should see error message as \"([^\"]*)\"$")
    public void isErrorMessageDisplayed(String errMsg){
        Assert.assertEquals(errMsg,loginPage.getLoginErrorMsg());
    }
}