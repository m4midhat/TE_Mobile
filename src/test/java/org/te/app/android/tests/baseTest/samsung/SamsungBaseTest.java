package org.te.app.android.tests.baseTest.samsung;

import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
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
import java.util.Locale;
import java.util.Properties;

@Slf4j
public class SamsungBaseTest {

    DesiredCapabilities appCapabilities;
    public AndroidDriver androidDriver;
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
    public Faker faker = new Faker(Locale.US);


    @BeforeSuite
    public void setUp() throws IOException {
        String pathToApplication = System.getProperty("user.dir")+"/src/main/java/org/te/app/installationPackages/Samsung.apk";
        configProperties = new Properties();
        userCredentials = new Properties();
        configProperties = utils.initProperties("samsung");
        userCredentials = utils.initProperties("userCredentials");
        appCapabilities = new DesiredCapabilities();

        appCapabilities.setCapability("platformName", configProperties.getProperty("platformName"));
        appCapabilities.setCapability("appium:automationName", configProperties.getProperty("automationName"));
        appCapabilities.setCapability("appium:platformVersion", configProperties.getProperty("platformVersion"));
        appCapabilities.setCapability("appium:deviceName", configProperties.getProperty("deviceName"));
        appCapabilities.setCapability("appium:appPackage", configProperties.getProperty("appPackage"));
        appCapabilities.setCapability("appium:appActivity", configProperties.getProperty("appActivity"));
        appCapabilities.setCapability("autoDismissAlerts", true);
        appCapabilities.setCapability("appium:app", pathToApplication);
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), appCapabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(AppConstants.TIMEOUT));
        introWizardScreen = new introWizardScreen(androidDriver);
        if(AppConstants.TEST_RAIL_REPORTING) {
            TestRailUtils.testRailTestPlanID = TestRailUtils.connectTestRailAndCreateTestPlan();
        }
    }


    @AfterSuite
    public void tearDown() throws APIException, IOException {

        profileScreen = homeScreen.openProfileScreen();
        profileScreen.logoutFromApp();

        if (androidDriver != null) {
            androidDriver.quit();
        }
        TestRailUtils.closeTestPlan(TestRailUtils.testRailTestPlanID);
        log.info("Closing the suite .....");
        if (AppConstants.TEST_RAIL_REPORTING) {
            log.info("VIEW THE COMPLETE REPORT HERE : "+TestRailUtils.TestRailLink+"index.php?/plans/view/"+TestRailUtils.testRailTestPlanID);
        }
    }

}
