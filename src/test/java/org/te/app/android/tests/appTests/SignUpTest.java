package org.te.app.android.tests.appTests;

import com.github.javafaker.Faker;
import org.te.app.android.assertionConstants.signUpScreenConstants;
import org.te.app.android.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test(description = "Verify screen header")
    public void verifyScreenHeader(){
        Assert.assertEquals(signUpScreen.getHeader(), signUpScreenConstants.HEADER);
    }

    @Test(description = "Verify screen title")
    public void verifyScreenTitle(){
        Assert.assertEquals(signUpScreen.getTitle(), signUpScreenConstants.TITLE);
    }

    @Test(priority = 1, description = "Sign up to Application")
    public void signUpToApplicationTest() throws InterruptedException {
        Faker faker = new Faker();
        String nationality = faker.nation().nationality();
        enableLocationScreen = signUpScreen.signUp(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "P@ssword123", "Nov032005", nationality.substring(0, 2));
    }

}
