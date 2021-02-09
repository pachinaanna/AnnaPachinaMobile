package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.IPageObject;

import java.lang.reflect.Field;

public class WebPageObject implements IPageObject {

    WebPageObject webPageObject;

    public WebPageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(appiumDriver, this);
    }

    @Override
    public WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = webPageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(webPageObject);
    }
}
