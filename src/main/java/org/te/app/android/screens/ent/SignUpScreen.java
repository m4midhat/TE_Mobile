package org.te.app.android.screens.ent;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.te.app.android.androidActions.AndroidActions;
import org.te.app.android.utils.utils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SignUpScreen extends AndroidActions {

    AndroidDriver androidDriver;

    public SignUpScreen(AndroidDriver driver){
        super(driver);
        this.androidDriver = driver;
    }



    private WebElement header(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvWelcome"));
    }

    private WebElement title(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvTitle"));
    }

    private WebElement txtFirstName(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etFirstName"));
    }

    private WebElement txtLastName(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etLastName"));
    }

    private WebElement txtEmailAddress(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etEmail"));
    }

    private WebElement txtPassword(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etPassword"));
    }

    private WebElement ddDOB(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etDOB"));
    }

    private WebElement ddNationality(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etNationality"));
    }

    private WebElement btnCreateAccount(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnCreateAccount"));
    }

    private WebElement licenseAgreementLink(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvAcceptLicense"));
    }

    private WebElement alreadyHaveAccount(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvDontHaveAcc"));
    }

    private WebElement signInLink(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvSignin"));
    }

    private WebElement DOBMonth(){
        List<WebElement> dob = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/dpDate")).findElements(By.id("android:id/numberpicker_input"));
        return dob.get(0);
    }

    private WebElement DOBDate(){
        List<WebElement> dob = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/dpDate")).findElements(By.id("android:id/numberpicker_input"));
        return dob.get(1);
    }

    private WebElement DOBYear(){
        List<WebElement> dob = androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/dpDate")).findElements(By.id("android:id/numberpicker_input"));
        return dob.get(2);
    }

    private void setFirstName(String firstName){
        txtFirstName().clear();
        txtFirstName().sendKeys(firstName);
    }

    private void setLastName(String lastName){
        txtLastName().clear();
        txtLastName().sendKeys(lastName);
    }

    private void setEmailAddress(String emailAddress){
        txtEmailAddress().clear();
        txtEmailAddress().sendKeys(emailAddress);
    }

    private void setPassword(String password){
        txtPassword().clear();
        txtPassword().sendKeys(password);
    }

    private WebElement btnDone(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnDone"));
    }

    private WebElement btnCancel(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/btnCancel"));
    }

    private WebElement nationalityWindow(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/design_bottom_sheet"));
    }

    private WebElement nationalityWindowCancelBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvCancel"));
    }

    private WebElement nationalityWindowDoneBtn(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/tvDone"));
    }

    private WebElement nationalityWindowSearchTextBox(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/etSearch"));
    }

    private WebElement tickBtnAgainstFirstNationality(){
        return androidDriver.findElement(By.id("com.theentertainerme.entertainer:id/ivTick"));
    }





    public String getHeader(){
        return header().getText().replace("\n", " ").trim();
    }

    public String getTitle(){
        return title().getText().replace("\n"," ").trim();
    }

    public void clickBtnDoneAfterSelectingDOB(){
        btnDone().click();
    }

    public void clickBtnCancelAfterSelectingDOB(){
        btnCancel().click();
    }

    public void setMonth(String monthToBeSelected) {

        String currentMonth=DOBMonth().getText();
        String bounds = DOBMonth().getAttribute("bounds");
        String previousMonthBounds = androidDriver.findElement(By.id("android:id/pickers")).findElements(By.className("android.widget.NumberPicker")).get(0).findElement(By.className("android.widget.Button")).getAttribute("bounds");
        List<Integer> sourceCoordinates = utils.extractBounds(bounds);
        List<Integer> destinationCoordinates = utils.extractBounds(previousMonthBounds);

        while (currentMonth.compareToIgnoreCase(monthToBeSelected)!=0) {

            final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Point start = new Point((sourceCoordinates.get(0)+sourceCoordinates.get(2))/2, (sourceCoordinates.get(1)+sourceCoordinates.get(3))/2);
            Point end = new Point((destinationCoordinates.get(0)+destinationCoordinates.get(2))/2, (destinationCoordinates.get(1)+destinationCoordinates.get(3))/2);
            Sequence swipe = new Sequence(FINGER, 1)
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(0),
                                    PointerInput.Origin.viewport(),
                                    start.getX(),
                                    start.getY()))
                    .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(200),
                                    PointerInput.Origin.viewport(),
                                    end.getX(),
                                    end.getY()))
                    .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            androidDriver.perform(Arrays.asList(swipe));
            currentMonth = DOBMonth().getText();
        }
    }

    public void setDate(String dateToBeSelected){
        String currentDate = DOBDate().getText();
        String bounds = DOBDate().getAttribute("bounds");
        String previousDateBounds = androidDriver.findElement(By.id("android:id/pickers")).findElements(By.className("android.widget.NumberPicker")).get(1).findElement(By.className("android.widget.Button")).getAttribute("bounds");
        String nextDateBounds = androidDriver.findElement(By.id("android:id/pickers")).findElements(By.className("android.widget.NumberPicker")).get(1).findElements(By.className("android.widget.Button")).get(1).getAttribute("bounds");

        List<Integer> sourceCoordinates = utils.extractBounds(bounds);
        List<Integer> destinationCoordinates = utils.extractBounds(previousDateBounds);
        if(Integer.parseInt(currentDate)<Integer.parseInt(dateToBeSelected)) {
            final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Point start = new Point((sourceCoordinates.get(0)+sourceCoordinates.get(2))/2, (sourceCoordinates.get(1)+sourceCoordinates.get(3))/2);
            Point end = new Point((destinationCoordinates.get(0)+destinationCoordinates.get(2))/2, (destinationCoordinates.get(1)+destinationCoordinates.get(3))/2);
            while (dateToBeSelected.compareToIgnoreCase(currentDate)!=0) {
                Sequence swipe = new Sequence(FINGER, 1)
                        .addAction(
                                FINGER.createPointerMove(
                                        Duration.ofMillis(0),
                                        PointerInput.Origin.viewport(),
                                        start.getX(),
                                        start.getY()))
                        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(
                                FINGER.createPointerMove(
                                        Duration.ofMillis(250),
                                        PointerInput.Origin.viewport(),
                                        end.getX(),
                                        end.getY()))
                        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                androidDriver.perform(Arrays.asList(swipe));
                currentDate = DOBDate().getText();
            }
        }
        else
        if(Integer.parseInt(currentDate)>Integer.parseInt(dateToBeSelected)) {
            destinationCoordinates = utils.extractBounds(nextDateBounds);
            final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Point start = new Point((sourceCoordinates.get(0)+sourceCoordinates.get(2))/2, (sourceCoordinates.get(1)+sourceCoordinates.get(3))/2);
            Point end = new Point((destinationCoordinates.get(0)+destinationCoordinates.get(2))/2, (destinationCoordinates.get(1)+destinationCoordinates.get(3))/2);
            while (dateToBeSelected.compareToIgnoreCase(currentDate)!=0) {
                Sequence swipe = new Sequence(FINGER, 1)
                        .addAction(
                                FINGER.createPointerMove(
                                        Duration.ofMillis(0),
                                        PointerInput.Origin.viewport(),
                                        start.getX(),
                                        start.getY()))
                        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                        .addAction(
                                FINGER.createPointerMove(
                                        Duration.ofMillis(250),
                                        PointerInput.Origin.viewport(),
                                        end.getX(),
                                        end.getY()))
                        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                androidDriver.perform(Arrays.asList(swipe));
                currentDate = DOBDate().getText();
            }
        }
    }

    public void setYear(String yearToBeSelected){
        String currentYear = DOBYear().getText();

        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(740, 1200);
        Point end = new Point(740, 1355);
        while (yearToBeSelected.compareToIgnoreCase(currentYear)!=0) {
            Sequence swipe = new Sequence(FINGER, 1)
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(0),
                                    PointerInput.Origin.viewport(),
                                    start.getX(),
                                    start.getY()))
                    .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(
                            FINGER.createPointerMove(
                                    Duration.ofMillis(250),
                                    PointerInput.Origin.viewport(),
                                    end.getX(),
                                    end.getY()))
                    .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            androidDriver.perform(Arrays.asList(swipe));
            currentYear = DOBYear().getText();
        }
    }

    public void setDOB(String month, String dt, String year){
        ddDOB().click();
        setMonth(month);
        setDate(dt);
        setYear(year);
        clickBtnDoneAfterSelectingDOB();
    }

    public void clickNationalityDropDown(){
        ddNationality().click();
    }

    public EnableLocationScreen signUp(String firstname, String lastname, String email, String password, String dob, String country) throws InterruptedException {
        String mm = dob.substring(0,3);
        String dd = dob.substring(3,5);
        String yyyy = dob.substring(5,9);

        System.out.println(mm+" : "+dd+" : "+yyyy);
        setFirstName(firstname);
        setLastName(lastname);
        setEmailAddress(email);
        setPassword(password);
        setDOB(mm,dd,yyyy);
        selectNationality(country);
        btnCreateAccount().click();
        Thread.sleep(10000);
        return new EnableLocationScreen(androidDriver);
    }

    public boolean nationalityWindowGetsDisplayed(){
        return nationalityWindow().isDisplayed();
    }

    public void cancelNationalityWindow(){
        nationalityWindowCancelBtn().click();
    }

    public void doneNationalityWindow(){
        nationalityWindowDoneBtn().click();
    }

    public void selectNationality(String nationality){
        clickNationalityDropDown();
        nationalityWindowSearchTextBox().sendKeys(nationality);
        tickBtnAgainstFirstNationality().click();
        doneNationalityWindow();
    }


}
