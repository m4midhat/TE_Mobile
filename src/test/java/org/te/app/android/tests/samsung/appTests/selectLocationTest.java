package org.te.app.android.tests.samsung.appTests;

import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;


public class selectLocationTest extends SamsungBaseTest {

    Logger logger = Logger.getLogger(String.valueOf(selectLocationTest.class));
    @Test
    public void clickOK(){
        System.out.println(selectLocationScreen.getTopMessage());
        System.out.println(selectLocationScreen.getScreenMessage());
        selectLocationScreen.clickOKButton();
        List<String> allLocations = selectLocationScreen.getLocationsList();
        for(String location:allLocations){
            logger.info(location);
        }
    }
}
