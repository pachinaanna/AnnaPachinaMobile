package steps.nativeSteps;

import io.appium.java_client.AppiumDriver;

public class ActionNativeStep extends BaseNativeStep {

    public ActionNativeStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void goToRegisterPage() throws IllegalAccessException, NoSuchFieldException {
        signInPage.getWebElement("registerBtn").click();
    }

    public void createNewUser(String email, String userName, String password) throws IllegalAccessException,
            NoSuchFieldException {
        registrationPage.getWebElement("emailField").sendKeys(email);
        registrationPage.getWebElement("userNameField").sendKeys(userName);
        registrationPage.getWebElement("passwordField").sendKeys(password);
        registrationPage.getWebElement("confirmPasswordField").sendKeys(password);
        registrationPage.getWebElement("agreeCheckbox").click();
        registrationPage.getWebElement("registerNewAccountBtn").click();
    }

    public void signInAsUser(String email, String password) throws IllegalAccessException, NoSuchFieldException {
        signInPage.getWebElement("loginEmailField").sendKeys(email);
        signInPage.getWebElement("loginPasswordField").sendKeys(password);
        signInPage.getWebElement("signInBtn").click();
    }

}
