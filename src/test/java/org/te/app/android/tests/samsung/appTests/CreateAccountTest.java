package org.te.app.android.tests.samsung.appTests;

import com.github.javafaker.Faker;
import org.te.app.android.tests.baseTest.samsung.SamsungBaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreateAccountTest extends SamsungBaseTest {

    private List<String> countries = new ArrayList<>();
    private Faker faker = new Faker(Locale.US);


    @BeforeClass
    private void getCountries(){
        createAccount.openCountryOfResidenceDropDown();
        countries = createAccount.getAllCountries();
        createAccount.closeCountryDropDown();
    }


    @Test
    public void registrationTest() throws InterruptedException {
        selectLocationScreen = createAccount.registerNewUser(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(), "", "P@ssword1");

    }
}
