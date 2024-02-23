package org.te.app.android.tests.baseTest.samsung;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.screens.samsung.*;
import org.te.app.android.utils.TestRailUtils;
import org.te.app.android.utils.utils;
import org.te.app.testRail.APIException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
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
    public static List<String> favorites = new ArrayList<>();

    public Faker faker = new Faker(Locale.US);

    public AppiumDriverLocalService service;

    @BeforeSuite
    public void setUp() throws IOException {

        String pathToApplication = System.getProperty("user.dir")+"/src/main/java/org/te/app/installationPackages/Samsung.apk";
        configProperties = new Properties();
        userCredentials = new Properties();
        configProperties = utils.initProperties("samsung");
        userCredentials = utils.initProperties("userCredentials");

        service = new AppiumServiceBuilder().withAppiumJS(new File(configProperties.getProperty("appiumServiceLocation")))
                .withIPAddress("127.0.0.1").usingPort(4723)
                .withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
                .build();
        service.start();
        log.info("Appium Service Running : "+service.isRunning());

        appCapabilities = new DesiredCapabilities();

        appCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        appCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        appCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        appCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        appCapabilities.setCapability("appium:appPackage", configProperties.getProperty("appPackage"));
        appCapabilities.setCapability("appium:appActivity", configProperties.getProperty("appActivity"));
        appCapabilities.setCapability("appium:app", pathToApplication);
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
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
