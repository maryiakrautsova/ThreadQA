package luma.tests;

import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class LogOutTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(LogOutTest.class.getName());

    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is created and logged in, clicks Sign Out link. Sign In link is present and clickable.")
    @TmsLink("test-8")
    public void userSignOutTest() {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        boolean isSignInLinkPresent = frequentlyUsedMethods.createUser()
                .clickToSelectSignOut()
                .selectSignOut()
                .isSignInLinkVisible();

        LOGGER.info(String.format("Sign In link is present.", isSignInLinkPresent));

        Assertions.assertTrue(isSignInLinkPresent);
    }
}
