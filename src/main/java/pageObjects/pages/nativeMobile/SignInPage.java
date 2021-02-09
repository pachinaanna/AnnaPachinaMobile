package pageObjects.pages.nativeMobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.NativePageObject;

import java.lang.reflect.Field;

public class SignInPage extends NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    WebElement signInBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    WebElement registerBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    WebElement loginEmailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    WebElement loginPasswordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_form")
    WebElement loginForm;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_form")
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
