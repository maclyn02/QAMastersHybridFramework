package AutomationPractice.Pages;

import AutomationPractice.Utils.BrowserFactory;
import AutomationPractice.Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;

    public BasePage() {

        driver = BrowserFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
