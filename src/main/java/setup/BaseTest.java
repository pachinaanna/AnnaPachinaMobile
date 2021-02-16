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
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver;
    public ActionWebStep actionWebStep;
    public AssertionWebStep assertionWebStep;
    public ActionNativeStep actionNativeStep;
    public AssertionNativeStep assertionNativeStep;
    private Properties systemProperties = System.getProperties();

    @Override
    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "udid", "browserName", "app", "appPackage", "appActivity", "bundleId"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional String deviceName,
                      @Optional String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional String appPackage,
                      @Optional String appActivity,
                      @Optional String bundleId) {
        System.out.println("Before: app type - " + appType);
        systemProperties.setProperty("ts.appium", "https://EPM-TSTF:" + System.getProperty("token") + "@mobilecloud.epam.com/wd/hub");
        setAppiumDriver(platformName, deviceName, browserName, app, udid, appPackage, appActivity, bundleId);
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
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app,
                                 String udid, String appPackage, String appActivity, String bundleId) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);

        if (app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);

        System.out.println(System.getProperty("ts.appium"));
        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
