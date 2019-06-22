package AutomationPractice.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver driver;

    public static void startBrowser() {

        String basePath = "./src/main/resources/";

        if(AutomationConstants.REMOTE==true){

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", "chrome");
            caps.setCapability("version", "70.0");
            caps.setCapability("platform", "win10");

//            DesiredCapabilities caps = DesiredCapabilities.chrome();
//            caps.setCapability("platform", "Windows 8");
//            caps.setCapability("version", "58.0");

//            DesiredCapabilities caps = DesiredCapabilities.edge();
//            caps.setCapability("platform", "Windows 10");
//            caps.setCapability("version", "18.17763");

//            DesiredCapabilities caps = DesiredCapabilities.firefox();
//            caps.setCapability("platform", "Windows 7");
//            caps.setCapability("version", "65.0");

            try {
                driver = new RemoteWebDriver(new URL(AutomationConstants.GRID_URL),caps);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else{
            if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver",  basePath+"geckodriver.exe");
                driver = new FirefoxDriver();
            }
            else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", basePath+"chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if (AutomationConstants.BROWSER_TYPE.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", basePath+"IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }
        }

        driver.get(AutomationConstants.baseURL);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static void stopBrowser(){
        driver.close();
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            BrowserFactory.startBrowser();
        }
        return driver;
    }

}
