package AutomationPractice.Pages;

import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

    @FindBy(css="#account-creation_form")
    WebElement registrationForm;

//    @FindBy(xpath="//form[@id='account-creation_form']/div/div[2]/input")
//    WebElement fnameField;
//
//    @FindBy(xpath="//form/div/div/input[@name=\"customer_lastname\"]")
//    WebElement lnameField;
//
//    @FindBy(xpath="//form/div/div/input[@id=\"passwd\"]")
//    WebElement pwdField;
//
//    @FindBy(xpath="//form/div/p/input[@id=\"address1\"]")
//    WebElement addressField;
//
//    @FindBy(xpath="//form/div/p/input[@id=\"city\"]")
//    WebElement cityField;
//
//    @FindBy(xpath="//form/div/p/div/select[@id=\"id_state\"]")
//    WebElement stateField;
//
//    @FindBy(xpath="//form/div/p/input[@id=\"postcode\"]")
//    WebElement zipField;
//
//    @FindBy(xpath="//form/div/p/div/select[@id=\"id_country\"]")
//    WebElement countryField;
//
//    @FindBy(xpath="//form/div/p/input[@id=\"phone_mobile\"]")
//    WebElement mobileNumberField;
//
//    @FindBy(xpath="//form/div/button[@id=\"submitAccount\"]/span")
//    WebElement submitBtn;

    public RegisterPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean isRegistrationFormDisplayed(){return registrationForm.isDisplayed();}

//    public void enterFname(String fname){
//        fnameField.sendKeys(fname);
//    }
//    public void enterLname(String lname){
//        lnameField.sendKeys(lname);
//    }
//    public void enterPassword(String pass){
//        pwdField.sendKeys(pass);
//    }
//    public void enterAddress(String address){
//        addressField.sendKeys(address);
//    }
//    public void enterCity(String city){
//        cityField.sendKeys(city);
//    }
//    public void enterZip(String zip){
//        zipField.sendKeys(zip);
//    }
//    public void enterMobileNumber(String mob){
//        mobileNumberField.sendKeys(mob);
//    }
//    public void clickSubmitBtn(){
//        submitBtn.click();
//    }
//    public void selectState(String state){ Utils.selectFromSelectBox(stateField,state);}
//    public void selectCountry(String country){ Utils.selectFromSelectBox(countryField,country);}

}
