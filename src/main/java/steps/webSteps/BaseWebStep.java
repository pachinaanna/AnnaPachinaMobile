package steps.webSteps;

import io.appium.java_client.AppiumDriver;
import pageObjects.pages.webMobile.GoogleHomePage;
import pageObjects.pages.webMobile.GoogleSearchResultPage;
import setup.BaseTest;

public class BaseWebStep extends BaseTest {

    GoogleHomePage googleHomePage;
    GoogleSearchResultPage googleSearchResultsPage;

    public BaseWebStep(AppiumDriver appiumDriver) {
        googleHomePage = new GoogleHomePage(appiumDriver);
        googleSearchResultsPage = new GoogleSearchResultPage(appiumDriver);
    }
}
