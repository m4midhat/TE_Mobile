package org.te.app.android.tests.baseTest.ent;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.te.app.android.screens.ent.*;
import org.te.app.android.utils.utils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class EntertainerBaseTest {

    DesiredCapabilities appCapabilities;
    DesiredCapabilities settingCapabilities;
    public AndroidDriver androidDriver;
    public static OnboardingScreen onboardingScreen;
    public static SignInScreen signInScreen;
    public static EnableLocationScreen enableLocationScreen;
    public static ShowOffersScreen showOffersScreen;
    public static SignUpScreen signUpScreen;
    public static HomeScreen homeScreen;
    protected static Properties configProperties, userCredentials;

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {
        configProperties = new Properties();
        userCredentials = new Properties();
        configProperties = utils.initProperties("androidDevice");
        userCredentials = utils.initProperties("userCredentials");
        //settingCapabilities = new DesiredCapabilities();
        appCapabilities = new DesiredCapabilities();
        /*
        settingCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        settingCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        settingCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        settingCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        appCapabilities.setCapability("appium:appPackage", "com.android.settings");
        appCapabilities.setCapability("appium:appActivity", "com.android.settings.Settings");
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), appCapabilities);
        scrollToText("Location");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Location']")).click();
        Thread.sleep(5000);
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='App location permissions']")).click();
        Thread.sleep(5000);
        scrollToText("ENTERTAINER");
        androidDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='ENTERTAINER']")).click();
        Thread.sleep(5000);
        androidDriver.findElement(By.id("com.android.permissioncontroller:id/allow_always_radio_button")).click();
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
        scrollToDirection("up");
        scrollToText("Apps");

        Thread.sleep(5000);*/
        appCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        appCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        appCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        appCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        appCapabilities.setCapability("appium:app", System.getProperty("user.dir")+"/apps/Entertainer_8.19.08_2909_UAT.apk");
        appCapabilities.setCapability("appium:appPackage", configProperties.getProperty("appPackage"));
        appCapabilities.setCapability("appium:appActivity", configProperties.getProperty("appActivity"));

        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), appCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        //androidDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
        //androidDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3000));
        onboardingScreen = new OnboardingScreen(androidDriver);
    }


    @AfterSuite
    public void tearDown(){
        if (androidDriver != null) {
            androidDriver.quit();
        }
    }


}