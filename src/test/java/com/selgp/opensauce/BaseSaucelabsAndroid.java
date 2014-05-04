package com.selgp.opensauce;

import com.selgp.opensauce.appium.BaseAppiumTest;
import com.selgp.opensauce.automation.core.saucelabs.SauceREST;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by guillemhernandezsola on 04/05/14.
 */
public class BaseSaucelabsAndroid extends BaseAppiumTest {
    public final static String USER = System.getProperty("user", "unset");
    public final static String APIKEY = System.getProperty("apikey", "unset");
    public SauceREST client = new SauceREST(USER, APIKEY);
    private InheritableThreadLocal<WebDriver> globalDriver = new InheritableThreadLocal<WebDriver>();
    private String sessionId;
    private String testName;


    /**
     * Sets up appium.  You will need to either explictly set the sauce username/access key variables, or set
     * SAUCE_USER_NAME or SAUCE_USER_NAME environment variables to reference your Sauce account details.
     *
     * @throws Exception
     */
    @BeforeMethod(alwaysRun = true)
    protected void setup(Method method, Object[] testArguments) {
        // set up appium
        testName = method.getName() + "_" + testArguments.hashCode();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("id", testName);
        capabilities.setCapability("name", testName);
        capabilities.setCapability("device", "Android");
        capabilities.setCapability(CapabilityType.VERSION, "4.2");
        capabilities.setCapability("app", "http://s3.amazonaws.com/selgp/ContactManager.apk");
        capabilities.setCapability("app-package", "com.example.android.contactmanager");
        capabilities.setCapability("app-activity", ".ContactManager");
        try {
            globalDriver.set(new RemoteWebDriver(new URL("http://" + USER + ":" + APIKEY + "@ondemand.saucelabs.com:80/wd/hub"),
                    capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        sessionId = ((RemoteWebDriver) globalDriver.get()).getSessionId().toString();
    }

    @AfterMethod(alwaysRun = true)
    protected void teardown(ITestResult tr, Method method) {
        globalDriver.get().quit();
        if (tr.isSuccess()) {
            client.jobPassed(sessionId);
        } else {
            client.jobFailed(sessionId);
        }
    }

    protected WebDriver driver() {
        return globalDriver.get();
    }

}
