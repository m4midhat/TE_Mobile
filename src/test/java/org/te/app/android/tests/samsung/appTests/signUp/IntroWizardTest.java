package org.te.app.android.tests.samsung.appTests.signUp;

import org.te.app.android.assertionConstants.samsung.IntroWizardScreenConstants;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.te.app.android.utils.ComparisonType;
import org.te.app.android.utils.TestRailUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class IntroWizardTest extends SamsungBaseTest {
    public String[] testCaseIDsArray = {"55183", "55184", "55185", "55187", "55188", "55189", "55190", "55191", "55192",
            "55193", "55194", "55196", "55197", "55198", "55200", "55201", "55202", "55203"};
    @BeforeClass
    public void addTestCasesToTestRun(){
        TestRailUtils.createTestRun(TestRailUtils.testRailTestPlanID, "Samsung Introduction Screen", testCaseIDsArray);
    }

    public Logger logger=Logger.getLogger(IntroWizardTest.class);

    @Test(description = "Verify if the screen title is matching up")
    public void verifyScreenTitle(){
        String title = introWizardScreen.screenTitle();
        logger.info("Current header : "+ title);
        Assert.assertEquals(title, IntroWizardScreenConstants.SCREEN_TITLE);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[0]), ComparisonType.STRING_HARD_EQUAL, title, IntroWizardScreenConstants.SCREEN_TITLE, "Incorrect screen title");
    }

    @Test(description = "Verify if the pagination controls are available")
    public void verifyPageControlsAreDisplayed(){
        boolean controls = introWizardScreen.paginationControlsAvailable();
        logger.info("Pagination controls :"+ controls);
        if(controls)
            TestRailUtils.setTestCaseAsPassed(Integer.parseInt(testCaseIDsArray[1]));
        else
            TestRailUtils.setTestCaseAsFailed(Integer.parseInt(testCaseIDsArray[1]),"Pagination controls are not available");
        Assert.assertTrue(controls);
    }

    @Test(description = "Verify if the screen has 'skip' button")
    public void verifyIfScreenHasSkipButton(){
        boolean skip = introWizardScreen.skipButtonAvailable();
        logger.info("Skip button :"+ skip);
        if(skip)
            TestRailUtils.setTestCaseAsPassed(Integer.parseInt(testCaseIDsArray[2]));
        else
            TestRailUtils.setTestCaseAsFailed(Integer.parseInt(testCaseIDsArray[2]),"Skip button is not available");
        Assert.assertTrue(skip);
    }

    @Test(description = "Verify if the screen has 'Next' button")
    public void verifyIfNextButtonIsAvailable(){
        boolean next = introWizardScreen.nextButtonAvailable();
        logger.info("Next Button : "+ next);
        if(next)
            TestRailUtils.setTestCaseAsPassed(Integer.parseInt(testCaseIDsArray[3]));
        else
            TestRailUtils.setTestCaseAsFailed(Integer.parseInt(testCaseIDsArray[3]),"Next button is not available");
        Assert.assertTrue(next);
    }

    @Test(description = "Verify if the text for 'Next' button is matching up")
    public void verifyNextButtonText(){
        String btn = introWizardScreen.nextButtonText();
        logger.info("Next button text : "+ btn);
        if(btn.compareToIgnoreCase(IntroWizardScreenConstants.NEXT_BTN)==0)
            TestRailUtils.setTestCaseAsPassed(Integer.parseInt(testCaseIDsArray[4]));
        else
            TestRailUtils.setTestCaseAsFailed(Integer.parseInt(testCaseIDsArray[4]), "Incorrect button text for 'Next'");
        Assert.assertEquals(btn, IntroWizardScreenConstants.NEXT_BTN);
    }



    // Step 1

    @Test(description = "Verify if the mobile image is being displayed for step 1", priority = 1)
    public void verifyScreenImageIsBeingDisplayedForStep1(){
        boolean img = introWizardScreen.imageIsBeingDisplayed();
        logger.info("Image is being displayed : "+ img);
        if(img)
            TestRailUtils.setTestCaseAsPassed(Integer.parseInt(testCaseIDsArray[5]));
        else
            TestRailUtils.setTestCaseAsFailed(Integer.parseInt(testCaseIDsArray[5]), "Image is not being displayed");
        Assert.assertTrue(img);
    }

    @Test(description = "Verify the step title for step 1", priority = 1)
    public void verifyStepTitleForStep1(){
        String step1 = introWizardScreen.stepTitle();
        logger.info("Step :"+ step1);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[6]), ComparisonType.STRING_HARD_EQUAL, step1, IntroWizardScreenConstants.STEP1_TITLE, "Incorrect Step title");
        Assert.assertEquals(step1, IntroWizardScreenConstants.STEP1_TITLE);
    }

    @Test(description = "Verify the step sub-title for step 1", priority = 1)
    public void verifyStepSubTitleForStep1(){
        String subtitle = introWizardScreen.stepSubTitle();
        logger.info("Step Details : "+ subtitle);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[7]), ComparisonType.STRING_HARD_EQUAL, subtitle, IntroWizardScreenConstants.STEP1_SUB_TITLE, "Incorrect Step sub title");
        Assert.assertEquals(subtitle, IntroWizardScreenConstants.STEP1_SUB_TITLE);
    }

    // Step 2

    @Test(description = "Verify if the mobile image is being displayed for step 2", priority = 2)
    public void verifyScreenImageIsBeingDisplayedForStep2(){
        introWizardScreen.pressNextButton();
        boolean img = introWizardScreen.imageIsBeingDisplayed();
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[8]), img, "Image is not being displayed");
        logger.info("Image is being displayed : "+ img);
        Assert.assertTrue(img);
    }

    @Test(description = "Verify the step title for step 2", priority = 3)
    public void verifyStepTitleForStep2(){
        String title = introWizardScreen.stepTitle();
        logger.info("Step :"+ title);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[9]), ComparisonType.STRING_HARD_EQUAL, title, IntroWizardScreenConstants.STEP2_TITLE, "Incorrect Step title");
        Assert.assertEquals(title, IntroWizardScreenConstants.STEP2_TITLE);
    }

    @Test(description = "Verify the step sub-title for step 2", priority = 3)
    public void verifyStepSubTitleForStep2(){
        String subtitle = introWizardScreen.stepSubTitle();
        logger.info("Step Details : "+ subtitle);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[10]), ComparisonType.STRING_HARD_EQUAL, subtitle, IntroWizardScreenConstants.STEP2_SUB_TITLE, "Incorrect Step sub title");
        Assert.assertEquals(subtitle, IntroWizardScreenConstants.STEP2_SUB_TITLE);
    }

    // Step 3

    @Test(description = "Verify if the mobile image is being displayed for step 3", priority = 4)
    public void verifyScreenImageIsBeingDisplayedForStep3(){
        introWizardScreen.pressNextButton();
        boolean img = introWizardScreen.imageIsBeingDisplayed();
        logger.info("Image is being displayed : "+ img);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[11]), img, "image is not being displayed");
        Assert.assertTrue(img);
    }

    @Test(description = "Verify the step title for step 3", priority = 5)
    public void verifyStepTitleForStep3(){
        String title = introWizardScreen.stepTitle();
        logger.info("Step :"+ title);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[12]), ComparisonType.STRING_HARD_EQUAL, title,IntroWizardScreenConstants.STEP3_TITLE,"Incorrect title");
        Assert.assertEquals(title, IntroWizardScreenConstants.STEP3_TITLE);
    }

    @Test(description = "Verify the step sub-title for step 3", priority = 5)
    public void verifyStepSubTitleForStep3(){
        String subtitle = introWizardScreen.stepSubTitle();
        logger.info("Step Details : "+ subtitle);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[13]), ComparisonType.STRING_HARD_EQUAL, subtitle,IntroWizardScreenConstants.STEP3_SUB_TITLE,"Incorrect sub title");
        Assert.assertEquals(subtitle, IntroWizardScreenConstants.STEP3_SUB_TITLE);
    }

    // Step 4

    @Test(description = "Verify if the mobile image is being displayed for step 4", priority = 6)
    public void verifyScreenImageIsBeingDisplayedForStep4(){
        introWizardScreen.pressNextButton();
        boolean img = introWizardScreen.imageIsBeingDisplayed();
        logger.info("Image is being displayed : "+ img);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[14]), img, "Image is not being displayed");
        Assert.assertTrue(img);
    }

    @Test(description = "Verify the step title for step 4", priority = 7)
    public void verifyStepTitleForStep4(){
        String title = introWizardScreen.stepTitle();
        logger.info("Step :"+ title);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[15]), ComparisonType.STRING_HARD_EQUAL, title, IntroWizardScreenConstants.STEP4_TITLE, "Incorrect title");
        Assert.assertEquals(title, IntroWizardScreenConstants.STEP4_TITLE);
    }

    @Test(description = "Verify the step sub-title for step 4", priority = 7)
    public void verifyStepSubTitleForStep4(){
        String subtitle = introWizardScreen.stepSubTitle();
        logger.info("Step Details : "+ subtitle);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[16]), ComparisonType.STRING_HARD_EQUAL, subtitle, IntroWizardScreenConstants.STEP4_SUB_TITLE, "Incorrect sub title");
        Assert.assertEquals(subtitle, IntroWizardScreenConstants.STEP4_SUB_TITLE);
    }

    @Test(description = "Verify the button 'Done' is now available", priority = 7)
    public void verifyDoneButtonIsAvailable(){
        String btn = introWizardScreen.nextButtonText();
        logger.info("Button text : "+ btn);
        TestRailUtils.updateTestCase(Integer.parseInt(testCaseIDsArray[17]), ComparisonType.STRING_HARD_EQUAL, btn, IntroWizardScreenConstants.DONE_BTN, "Incorrect button text for next");
        Assert.assertEquals(btn, IntroWizardScreenConstants.DONE_BTN);
    }

    @AfterClass
    public void navigateToNextScreen(){
        loginScreen = introWizardScreen.navigateToLoginScreen();
    }

}
