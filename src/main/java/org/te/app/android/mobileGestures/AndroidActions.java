package org.te.app.android.mobileGestures;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndroidActions {

    AndroidDriver androidDriver;

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



    public void scroll(String direction){
        // Java
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) androidDriver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", direction,
                "percent", 3.0
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
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }



    public void scrollToText(String text)
    {
        androidDriver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
    }


    public void swipeAction(WebElement element,String direction)
    {
        ((JavascriptExecutor) androidDriver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)element).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }


}
