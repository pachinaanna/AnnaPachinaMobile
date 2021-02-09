package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.IPageObject;

import java.lang.reflect.Field;

public class NativePageObject implements IPageObject {

    NativePageObject nativePageObject;

    public NativePageObject(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @Override
    public WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = nativePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(nativePageObject);
    }

}
