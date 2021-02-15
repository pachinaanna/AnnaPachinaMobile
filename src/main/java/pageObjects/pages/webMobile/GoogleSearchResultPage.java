package pageObjects.pages.webMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.WebPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class GoogleSearchResultPage extends WebPageObject {

    @FindBy(xpath = "//*[@id='rso']/div")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable")
    public List<WebElement> searchingResults;

    public GoogleSearchResultPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

}
