package AutomationPractice.Utils;

import AutomationPractice.Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils extends BasePage {

    //----> Select an item from drop down box
    public void selectFromSelectBox(WebElement element, String visibleString){

        Select selState = new Select(element);
        selState.selectByVisibleText(visibleString);

    }
    public static void wait(int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    //-----> Explicitly wait for an element to become visible
    public static void waitForElement(WebElement element, int waitInSeconds){
        WebDriverWait wait1=new WebDriverWait(driver,waitInSeconds);
        wait1.until(ExpectedConditions.visibilityOf(element));
    }
    //-----> Hovers on one element and clicks on its child element displayed onhover
    public static void hoverAndClick(WebElement elementToHover, WebElement elementToClick){

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        elementToClick.click();

    }
    //-----> Scroll the page
    public static void scrollTo(int x,int y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll("+x+", "+y+");");
    }

}
