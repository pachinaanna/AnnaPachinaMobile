package steps.webSteps;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static setup.GetProperties.getTestProperties;

public class ActionWebStep extends BaseWebStep {

    public ActionWebStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void goToGoogle() throws IOException {
        getDriver().get(getTestProperties().getProperty("url"));
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
    }

    public void fillSearchFieldInGoogle(String text) throws NoSuchFieldException, IllegalAccessException {
        googleHomePage.getWebElement("searchField").sendKeys(text);
        googleHomePage.getWebElement("searchField").sendKeys(Keys.ENTER);
    }

}
