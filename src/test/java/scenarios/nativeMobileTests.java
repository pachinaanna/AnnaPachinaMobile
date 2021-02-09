package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

import static setup.GetProperties.getTestProperties;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "EPAMTestApp test")
    public void registerNewUserTest()
            throws IllegalAccessException, NoSuchFieldException, InstantiationException, IOException {

        actionNativeStep.goToRegisterPage();
        assertionNativeStep.assertThatRegistrationFormIsOpened();

        actionNativeStep.createNewUser(getTestProperties().getProperty("email"),
                getTestProperties().getProperty("userName"), getTestProperties().getProperty("password"));

        actionNativeStep.signInAsUser(getTestProperties().getProperty("email"),
                getTestProperties().getProperty("password"));

        assertionNativeStep.assertThatBudgetPageIsOpened(getTestProperties().getProperty("budget.page"));
    }

}
