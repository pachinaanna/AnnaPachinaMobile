package steps.webSteps;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

import java.io.IOException;

import static setup.GetProperties.getTestProperties;

public class AssertionWebStep extends BaseWebStep {

    public AssertionWebStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void assertThatGoogleHomePageIsOpened() throws IOException {
        Assert.assertEquals(getDriver().getTitle(),
                getTestProperties().getProperty("google.home.page"), "Google Home Page wasn't open");
    }

    public void assertThatSearchingResultIsNotEmpty() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertNotEquals(googleSearchResultsPage.getWebElements("searchingResults").size(), 0,
                "Searching result is empty");
    }
}
