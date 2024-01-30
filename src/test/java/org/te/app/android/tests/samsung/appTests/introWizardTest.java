package org.te.app.android.tests.samsung.appTests;

import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class introWizardTest extends SamsungBaseTest {

    public Logger logger=Logger.getLogger(introWizardTest.class);

    @Test(description = "Verify if the screen title is matching up")
    public void verifyScreenTitle(){
        logger.info("Current header : "+ introWizardScreen.screenTitle());
    }

    @Test(description = "Verify if the pagination controls are available")
    public void verifyPageControlsAreDisplayed(){
        logger.info("Pagination controls :"+ introWizardScreen.paginationControlsAvailable());
    }

    @Test(description = "Verify if the screen has 'skip' button")
    public void verifyIfScreenHasSkipButton(){
        logger.info("Skip button :"+ introWizardScreen.skipButtonAvailable());
    }

    @Test(description = "Verify if the screen has 'Next' button")
    public void verifyIfNextButtonIsAvailable(){
        logger.info("Next Button : "+ introWizardScreen.nextButtonAvailable());
    }

    @Test(description = "Verify if the text for 'Next' button")
    public void verifyNextButtonText(){
        logger.info("Next button text : "+ introWizardScreen.nextButtonText());
    }



    // Step 1

    @Test(description = "Verify if the mobile image is being displayed for step 1", priority = 1)
    public void verifyScreenImageIsBeingDisplayedForStep1(){
        logger.info("Image is being displayed : "+ introWizardScreen.imageIsBeingDisplayed());
    }

    @Test(description = "Verify the step title for step 1", priority = 1)
    public void verifyStepTitleForStep1(){
        logger.info("Step :"+ introWizardScreen.stepTitle());
    }

    @Test(description = "Verify the step sub-title for step 1", priority = 1)
    public void verifyStepSubTitleForStep1(){
        logger.info("Step Details : "+ introWizardScreen.stepSubTitle());
    }

    // Step 2

    @Test(description = "Verify if the mobile image is being displayed for step 2", priority = 2)
    public void verifyScreenImageIsBeingDisplayedForStep2(){
        introWizardScreen.pressNextButton();
        logger.info("Image is being displayed : "+ introWizardScreen.imageIsBeingDisplayed());
    }

    @Test(description = "Verify the step title for step 2", priority = 2)
    public void verifyStepTitleForStep2(){
        logger.info("Step :"+ introWizardScreen.stepTitle());
    }

    @Test(description = "Verify the step sub-title for step 2", priority = 2)
    public void verifyStepSubTitleForStep2(){
        logger.info("Step Details : "+ introWizardScreen.stepSubTitle());
    }

    // Step 3

    @Test(description = "Verify if the mobile image is being displayed for step 3", priority = 3)
    public void verifyScreenImageIsBeingDisplayedForStep3(){
        introWizardScreen.pressNextButton();
        logger.info("Image is being displayed : "+ introWizardScreen.imageIsBeingDisplayed());
    }

    @Test(description = "Verify the step title for step 3", priority = 3)
    public void verifyStepTitleForStep3(){
        logger.info("Step :"+ introWizardScreen.stepTitle());
    }

    @Test(description = "Verify the step sub-title for step 3", priority = 3)
    public void verifyStepSubTitleForStep3(){
        logger.info("Step Details : "+ introWizardScreen.stepSubTitle());
    }

    // Step 4

    @Test(description = "Verify if the mobile image is being displayed for step 4", priority = 4)
    public void verifyScreenImageIsBeingDisplayedForStep4(){
        introWizardScreen.pressNextButton();
        logger.info("Image is being displayed : "+ introWizardScreen.imageIsBeingDisplayed());
    }

    @Test(description = "Verify the step title for step 3", priority = 4)
    public void verifyStepTitleForStep4(){
        logger.info("Step :"+ introWizardScreen.stepTitle());
    }

    @Test(description = "Verify the step sub-title for step 3", priority = 4)
    public void verifyStepSubTitleForStep4(){
        logger.info("Step Details : "+ introWizardScreen.stepSubTitle());
    }

    @Test(description = "Verify the button 'Done' is now available", priority = 10)
    public void verifyDoneButtonIsAvailable(){
        logger.info("Button text : "+ introWizardScreen.nextButtonText());
        loginScreen = introWizardScreen.navigateToLoginScreen();
    }

}
