package luma.tests;

import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import luma.pages.CustomerAccountPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class LoginTest extends BaseSeleniumTest {
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is created and logged in, clicks Sign Out link, clicks Sign In link, inputs email and password." +
            "Account name equals to 'Home Page'.")
    public void signInTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        frequentlyUsedMethods.createUser();
        String userEmail = frequentlyUsedMethods.getEmail();
        String userPassword = frequentlyUsedMethods.getPassword();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage();
        String myAccountName = customerAccountPage.clickToSelectSignOut()
                .selectSignOut()
                .clickSignInLink()
                .signInUser(userEmail, userPassword)
                .getMyAccountName();

        Assertions.assertEquals("Home Page", myAccountName);
    }
}
