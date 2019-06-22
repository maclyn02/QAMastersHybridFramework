package AutomationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends BasePage {

    @FindBy(css=".info-account")
    WebElement accInfo;

    public UserAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isAccInfoDisplayed(){
        if(accInfo.isDisplayed())
            return true;
        else
            return false;
    }
}
