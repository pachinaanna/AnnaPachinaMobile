package pageObjects.pages.nativeMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;

import java.lang.reflect.Field;

public class SignInPage extends NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    WebElement registerBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Username or email']")
    WebElement loginEmailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Password']")
    WebElement loginPasswordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_form")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@label='Registration']")
    WebElement loginForm;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_form")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Registration']")
    WebElement registrationForm;

    public SignInPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public WebElement getWebElement(String weName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(this);
    }
}
