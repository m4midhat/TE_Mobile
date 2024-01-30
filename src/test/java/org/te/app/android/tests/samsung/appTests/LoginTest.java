package org.te.app.android.tests.samsung.appTests;

import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.annotations.Test;

public class LoginTest extends SamsungBaseTest {


    @Test
    public void createAccountTest(){
        createAccount = loginScreen.clickCreateAccount();
    }

}
