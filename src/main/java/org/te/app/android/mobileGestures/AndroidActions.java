package org.te.app.android.mobileGestures;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.te.app.android.AppConstants.AppConstants;
import org.te.app.android.utils.utils;

import java.io.File;
import java.io.IOException;
import io.appium.java_client.screenrecording.CanRecordScreen;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class AndroidActions {

    static AndroidDriver androidDriver;

    public AndroidActions(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }



    public void scroll(){
        try
        {     androidDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
        )); }
        catch
        (InvalidSelectorException e) {
// ignore
        }
    }


    public void longClick(WebElement element){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }


    public void doubleClick(WebElement element){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }



    public void click(WebElement element){
        // Java
        androidDriver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }



    public void drag(WebElement element, int x, int y){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", x,
                "endY", y
        ));
    }



    public void fling(WebElement element, String direction){
        // Java
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "speed", 500
        ));
    }



    public void pinchAndClose(WebElement element){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75
        ));
    }



    public void swipe(String direction){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 0.75
        ));
    }



    public void pinch(WebElement element){
        // Java
        ((JavascriptExecutor) androidDriver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75
        ));
    }



    public void scrollToTop(){
        Dimension size = androidDriver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        endY = (int) (size.height * 0.70);
        startY = (int) (size.height * 0.30);
        startX = (size.width / 2);
        new TouchAction(androidDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }



    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }



    public void longPressAction(WebElement element, int duration)
    {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
                        "duration",duration));
    }


    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 5.0

            ));
        }while(canScrollMore);
    }

    public void scrollToEndAction(int percent)
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", percent

            ));
        }while(canScrollMore);
    }



    public void scrollToText(String text)
    {
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }


    public void swipeAction(WebElement element,String direction) {
        if (element.getAttribute("focusable").compareToIgnoreCase("true") == 0) {
            ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", direction,
                    "percent", 0.9
            ));
        }
        else
            log.error("ERROR!\nSelected element is not swipe-able");
    }

    public void swipeTwoCoordinates(List<Integer> source, List<Integer> destination){
        int startX, startY, endX, endY;
        startX = (source.get(0)+ source.get(2))/2;
        startY = (source.get(1)+ source.get(3))/2;

        endX = (destination.get(0)+ destination.get(2))/2;
        endY = (destination.get(1)+ destination.get(3))/2;

        log.info("Performing swiping on the following co-ordinates .....");
        log.info(startX+":"+startY);
        log.info(endX+":"+endY);


        final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);
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
                                Duration.ofMillis(1000),
                                PointerInput.Origin.viewport(),
                                end.getX(),
                                end.getY()))
                .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        androidDriver.perform(Arrays.asList(swipe));
    }

    public void swipeTwoObjects(WebElement sourceObject, WebElement destinationObject){
        List<Integer> sourceCoordinates = utils.extractBounds(sourceObject.getAttribute("bounds"));
        List<Integer> destinationCoordinates = utils.extractBounds(destinationObject.getAttribute("bounds"));

        swipeTwoCoordinates(sourceCoordinates, destinationCoordinates);
    }


    public void performMultipleScrolls(int scrollCount){
        for(int i=0;i<scrollCount;i++){
            scroll();
        }
    }

    public static String takeScreenshot() throws IOException {
        String filename = utils.getCurrentlyDateTimeInMilliSeconds() + ".png";
        String path = System.getProperty("user.dir") + "/screenshot/";
        String screenshotFile = path+filename;

        File file = androidDriver.getScreenshotAs(OutputType.FILE);
        File dest = new File(screenshotFile);
        FileUtils.copyFile(file, dest);
        log.info(dest.getAbsolutePath());
        return dest.getAbsolutePath();
    }


    public static void startRecording()  {
        if(AppConstants.VIDEO_REC.compareToIgnoreCase("yes")==0) {
            androidDriver.startRecordingScreen(new AndroidStartScreenRecordingOptions()
                    .withTimeLimit(Duration.ofMinutes(10)));
        }
    }

    public static void stopRecording(String fileName) throws IOException {
        if (AppConstants.VIDEO_REC.compareToIgnoreCase("yes") == 0) {

            String base64String = ((CanRecordScreen) androidDriver).stopRecordingScreen();
            String filename = fileName + utils.getCurrentlyDateTime() + ".mp4";
            byte[] data = Base64.decodeBase64(base64String);
            String path = System.getProperty("user.dir") + "/videos/";
            String videoFile = path + filename;
            Path videoPath = Paths.get(videoFile);
            Files.write(videoPath, data);
            log.info("*** VIEW THE COMPLETE VIDEO : " + videoFile + " ***");
        }
    }


}