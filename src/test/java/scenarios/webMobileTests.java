package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

import java.io.IOException;

import static setup.GetProperties.getTestProperties;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Using Google search test")
    public void googleSearchTest() throws IllegalAccessException, NoSuchFieldException, IOException {
        actionWebStep.goToGoogle();

        assertionWebStep.assertThatGoogleHomePageIsOpened();

        actionWebStep.fillSearchFieldInGoogle(getTestProperties().getProperty("text"));
        assertionWebStep.assertThatSearchingResultIsNotEmpty();
    }

}
