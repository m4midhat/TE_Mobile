package org.te.app.android.tests.baseTest.samsung;

import com.github.javafaker.Faker;
import io.appium.java_client.Location;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.geolocation.AndroidGeoLocation;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.screens.samsung.*;
import org.te.app.android.utils.TestRailUtils;
import org.te.app.android.utils.utils;
import org.te.app.testRail.APIException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

import static org.te.app.android.mobileGestures.AndroidActions.startRecording;
import static org.te.app.android.mobileGestures.AndroidActions.stopRecording;

@Slf4j
public class SamsungBaseTest {

    DesiredCapabilities appCapabilities;
    public static AndroidDriver androidDriver;
    protected static Properties configProperties, userCredentials;
    protected static introWizardScreen introWizardScreen;
    protected static loginScreen loginScreen;
    protected static createAccountScreen createAccount;
    protected static selectLocationScreen selectLocationScreen;
    protected static HomeScreen homeScreen;
    protected static ProfileScreen profileScreen;
    protected static SearchScreen searchScreen;
    protected static FashionRetailScreen fashionRetailScreen;
    protected static FoodAndDrinksScreen foodAndDrinksScreen;
    protected static BeautyAndFitnessScreen beautyAndFitnessScreen;
    protected static ProfileDetailsScreen profileDetailsScreen;
    protected static MerchantDetailsScreen merchantDetailsScreen;
    protected static FavouriteScreen favouriteScreen;
    public static String currency_at_home ;
    public Faker faker = new Faker(Locale.US);

    public static AppiumDriverLocalService service;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        String pathToApplication = System.getProperty("user.dir")+"/src/main/java/org/te/app/installationPackages/Samsung.apk";
        configProperties = new Properties();
        userCredentials = new Properties();
        configProperties = utils.initProperties("samsung");
        userCredentials = utils.initProperties("userCredentials");

        service = utils.initService(configProperties.getProperty("appiumServiceLocation"));
        service.start();
        log.info("Appium Service Running : "+service.isRunning());

        appCapabilities = new DesiredCapabilities();

        appCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        appCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        appCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        //if(AppConstants.TEST_DEVICE == null) {
        //    log.warn("WARNING!\nNo device name was provided, using the default device : "+configProperties.getProperty("deviceName"));
            appCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        //}
        //else {
        //    appCapabilities.setCapability("appium:deviceName", AppConstants.TEST_DEVICE);
        //}

        appCapabilities.setCapability("appium:appPackage", configProperties.getProperty("appPackage"));
        appCapabilities.setCapability("appium:appActivity", configProperties.getProperty("appActivity"));
        appCapabilities.setCapability("appium:app", pathToApplication);
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4725/"), appCapabilities);

        AndroidGeoLocation androidGeoLocation = new AndroidGeoLocation();
        androidGeoLocation.withLatitude(25.1972).withLongitude(55.2797).build();
        androidDriver.setLocation(androidGeoLocation);

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstants.TIMEOUT));
        introWizardScreen = new introWizardScreen(androidDriver);
        if(AppConstants.TEST_RAIL_REPORTING) {
            TestRailUtils.testRailTestPlanID = TestRailUtils.connectTestRailAndCreateTestPlan();
        }
        startRecording();
    }




    @AfterSuite
    public void tearDown() throws APIException, IOException {

        profileScreen = homeScreen.openProfileScreen();
        profileScreen.logoutFromApp();
        stopRecording("Samsung");

        if (androidDriver != null) {
            androidDriver.quit();
        }
        TestRailUtils.closeTestPlan(TestRailUtils.testRailTestPlanID);
        log.info("Closing the suite .....");
        if (AppConstants.TEST_RAIL_REPORTING) {
            log.info("VIEW THE COMPLETE REPORT HERE : "+TestRailUtils.TestRailLink+"index.php?/plans/view/"+TestRailUtils.testRailTestPlanID);
        }

        if(service.isRunning()) {
            service.stop();
        }
    }

}
