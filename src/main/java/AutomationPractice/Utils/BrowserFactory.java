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
