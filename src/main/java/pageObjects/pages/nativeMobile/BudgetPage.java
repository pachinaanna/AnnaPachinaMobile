package pageObjects.pages.nativeMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;

import java.lang.reflect.Field;

public class BudgetPage extends NativePageObject {

    BudgetPage budgetPage;
    @AndroidFindBy(xpath = "//*[contains(@text, 'BudgetActivity')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
    WebElement budgetActivityTitle;

    public BudgetPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(this);
    }
}
