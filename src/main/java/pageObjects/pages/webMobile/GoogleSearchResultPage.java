package pageObjects.pages.webMobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.WebPageObject;

import java.lang.reflect.Field;
import java.util.List;

public class GoogleSearchResultPage extends WebPageObject {

    @FindBy(xpath = "//*[@id='rso']/div")
    public List<WebElement> searchingResults;

    public GoogleSearchResultPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public List<WebElement> getWebElements(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (List<WebElement>) field.get(this);
    }

}
