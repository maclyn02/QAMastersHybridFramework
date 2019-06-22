package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id=\"login_form\"]/div/div[1]/input")
    WebElement emailField;

    @FindBy(xpath = "//form[@id=\"login_form\"]/div/div[2]/span/input")
    WebElement passwdField;

    @FindBy(xpath = "//button[@id=\"SubmitLogin\"]/span")
    WebElement loginBtn;

    @FindBy(css=".alert-danger")
    WebElement loginError;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li")
    WebElement loginErrorMsg;

    @FindBy(css="#login_form")
    WebElement loginForm;

    @FindBy(css="#create-account_form")
    WebElement createAccForm;

    @FindBy(css="#email_create")
    WebElement createEmailField;

    @FindBy(xpath="//div[@class=\"submit\"]/button/span")
    WebElement createBtn;

    @FindBy(css="#create_account_error")
    WebElement regError;

    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[1]/ol/li")
    WebElement regErrorMsg;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isUserOnLoginPage(){
        if(getTitle().equalsIgnoreCase("login - my store"))
            return true;
        else
            return false;
    }
    //Login
    public boolean isLoginFormDisplayed(){
        if(loginForm.isDisplayed())
            return true;
        else
            return false;
    }
    public void enterCredentials(String email,String passwd){
        emailField.sendKeys(email);
        passwdField.sendKeys(passwd);
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
    public boolean isLoginErrorDisplayed(){
        Utils.waitForElement(loginError,10);
        if(loginError.isDisplayed())
            return true;
        else
            return false;
    }
    public String getLoginErrorMsg(){ return loginErrorMsg.getText();}
    //Registration
    public void enterRegistrationEmail(String uemail){
        createEmailField.sendKeys(uemail);
    }
    public void clickCreateBtn(){
        createBtn.click();
    }
    public boolean isRegistrationFormDisplayed(){return createAccForm.isDisplayed();}

    public boolean isAccErrorDisplayed(){
        Utils.waitForElement(regError,10);
        if(regError.isDisplayed())
            return true;
        else
            return false;
    }
    public String getRegErrorMsg(){ return regErrorMsg.getText(); }
}
