package steps.nativeSteps;

import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class AssertionNativeStep extends BaseNativeStep {

    public AssertionNativeStep(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void assertThatBudgetPageIsOpened(String browserTitle) throws IllegalAccessException,
            NoSuchFieldException {
        Assert.assertEquals(budgetPage.getWebElement("budgetActivityTitle").getText(), browserTitle,
                "BudgetActivity page wasn't opened");
    }

    public void assertThatRegistrationFormIsOpened() throws NoSuchFieldException, IllegalAccessException {
        Assert.assertTrue(signInPage.getWebElement("registrationForm").isDisplayed(),
                "Registration form wasn't opened");
    }
}
