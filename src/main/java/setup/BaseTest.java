package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import steps.nativeSteps.ActionNativeStep;
import steps.nativeSteps.AssertionNativeStep;
import steps.webSteps.ActionWebStep;
import steps.webSteps.AssertionWebStep;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver;
    public ActionWebStep actionWebStep;
    public AssertionWebStep assertionWebStep;
    public ActionNativeStep actionNativeStep;
    public AssertionNativeStep assertionNativeStep;

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName,
                      @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        initializeSteps(appType);
    }

    @BeforeMethod
    public void initializeSteps(String appType) {
        if ("web".equals(appType)) {
            actionWebStep = new ActionWebStep(appiumDriver);
            assertionWebStep = new AssertionWebStep(appiumDriver);
        } else if ("native".equals(appType)) {
            actionNativeStep = new ActionNativeStep(appiumDriver);
            assertionNativeStep = new AssertionNativeStep(appiumDriver);
        } else {
            throw new IllegalArgumentException(appType + "is not supported");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);

        if (app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
