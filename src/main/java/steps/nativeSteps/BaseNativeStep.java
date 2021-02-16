package steps.nativeSteps;

import io.appium.java_client.AppiumDriver;
import pageObjects.pages.nativeMobile.BudgetPage;
import pageObjects.pages.nativeMobile.RegistrationPage;
import pageObjects.pages.nativeMobile.SignInPage;
import setup.BaseTest;

public class BaseNativeStep extends BaseTest {
    SignInPage signInPage;
    RegistrationPage registrationPage;
    BudgetPage budgetPage;

    public BaseNativeStep(AppiumDriver appiumDriver) {
        signInPage = new SignInPage(appiumDriver);
        registrationPage = new RegistrationPage(appiumDriver);
        budgetPage = new BudgetPage(appiumDriver);
    }

}
