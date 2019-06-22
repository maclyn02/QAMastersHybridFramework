package AutomationPractice.StepDefinitions;

import AutomationPractice.Utils.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void setUp(){ BrowserFactory.startBrowser();    }

    @After
    public void cleanUp(){  BrowserFactory.stopBrowser();
    }
}
