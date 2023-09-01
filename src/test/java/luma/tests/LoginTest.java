package luma.tests;

import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import luma.pages.CustomerAccountPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class LoginTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is created and logged in, clicks Sign Out link, clicks Sign In link, inputs email and password." +
            "Account name equals to 'Home Page'.")
    @TmsLink("test-7")
    public void signInTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();

        LOGGER.info(String.format("Attempt to create a new user."));
        frequentlyUsedMethods.createUser();
        String userEmail = frequentlyUsedMethods.getEmail();
        LOGGER.info(String.format("Attempt to get user email.", userEmail));

        String userPassword = frequentlyUsedMethods.getPassword();
        LOGGER.info(String.format("Attempt to get user password.", userPassword));


        CustomerAccountPage customerAccountPage = new CustomerAccountPage();
        String myAccountName = customerAccountPage.clickToSelectSignOut()
                .selectSignOut()
                .clickSignInLink()
                .signInUser(userEmail, userPassword)
                .getMyAccountName();
        LOGGER.info(String.format("Attempt to actual Account name.", myAccountName));

        Assertions.assertEquals("Home Page", myAccountName);
    }
}
