package luma.tests;

import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class LogOutTest extends BaseSeleniumTest {
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is created and logged in, clicks Sign Out link. Sign In link is present and clickable.")
    public void userSignOutTest() {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        boolean isSignInLinkPresent = frequentlyUsedMethods.createUser()
                .clickToSelectSignOut()
                .selectSignOut()
                .isSignInLinkVisible();

        Assertions.assertTrue(isSignInLinkPresent);
    }
}
