package org.te.app.android.tests.baseTest.samsung;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.te.app.android.screens.samsung.createAccountScreen;
import org.te.app.android.screens.samsung.introWizardScreen;
import org.te.app.android.screens.samsung.loginScreen;
import org.te.app.android.screens.samsung.selectLocationScreen;
import org.te.app.android.utils.utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class SamsungBaseTest {

    DesiredCapabilities appCapabilities;
    public AndroidDriver androidDriver;
    protected static Properties configProperties, userCredentials;
    protected static introWizardScreen introWizardScreen;
    protected static loginScreen loginScreen;
    protected static createAccountScreen createAccount;
    protected static selectLocationScreen selectLocationScreen;
    public Faker faker = new Faker(Locale.US);


    @BeforeSuite
    public void setUp() throws IOException {
        configProperties = new Properties();
        userCredentials = new Properties();
        configProperties = utils.initProperties("androidDevice");
        userCredentials = utils.initProperties("userCredentials");
        appCapabilities = new DesiredCapabilities();

        appCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        appCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        appCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        appCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        appCapabilities.setCapability("appium:appPackage", configProperties.getProperty("samsungAppPackage"));
        appCapabilities.setCapability("appium:appActivity", configProperties.getProperty("samsungAppActivity"));

        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), appCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        introWizardScreen = new introWizardScreen(androidDriver);
    }


    @AfterSuite
    public void tearDown(){
        if (androidDriver != null) {
            androidDriver.quit();
        }
    }

}
