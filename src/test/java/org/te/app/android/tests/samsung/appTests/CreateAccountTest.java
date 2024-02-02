package org.te.app.android.tests.samsung.appTests;

import com.github.javafaker.Faker;
import org.te.app.android.assertionConstants.samsung.CreateAccountScreen;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class CreateAccountTest extends SamsungBaseTest {

    private List<String> countries = new ArrayList<>();
    private Faker faker = new Faker(Locale.US);


    @BeforeClass
    private void getCountries(){
        createAccount.openCountryOfResidenceDropDown();
        countries = createAccount.getAllCountries();
        createAccount.closeCountryDropDown();
    }


    @Test(description = "Verify the countries list")
    public void verifyCountriesList(){
        SoftAssert softAssert = new SoftAssert();
        int index = 0;
       // Assert.assertEquals(countries, Arrays. CreateAccountScreen.NATIONALITIES);
        for(String nationality:CreateAccountScreen.NATIONALITIES){
            softAssert.assertEquals(nationality, countries.get(index));
            index++;
        }
        softAssert.assertAll();
    }

    @Test(priority = 200)
    public void registrationTest() throws InterruptedException {
        selectLocationScreen = createAccount.registerNewUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "", "P@ssword1");

    }
}
