package pageObjects.pages.webMobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.WebPageObject;

import java.lang.reflect.Field;

public class GoogleHomePage extends WebPageObject {

    public GoogleHomePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchField;

    public WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(this);
    }}
