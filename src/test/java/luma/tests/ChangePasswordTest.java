package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class ChangePasswordTest extends BaseSeleniumTest {

    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordTest.class.getName());

    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, clicks Change Password link, fills in Change Password fields and presses Save button." +
            "Changed password alert is present.")
    @TmsLink("test-3")
    public void changePasswordTest() {
        String newUserPassword = Faker.instance().internet().password(10, 15,
                true, true);
        LOGGER.info(String.format("New user password is generated.", newUserPassword));

        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String userPassword = frequentlyUsedMethods.getPassword();
        LOGGER.info(String.format("User first password is being got.", userPassword));

        LOGGER.info(String.format("User first password is being got."));
        String changedPasswordAlertText = frequentlyUsedMethods.createUser()
                .clickChangePasswordLink()
                .fillInChangePasswordFieldsAndSave(userPassword, newUserPassword)
                .changedPasswordAlertPoppedUpMessage();
        LOGGER.info(String.format("Successfully changed user password alert is present.", changedPasswordAlertText));
        Assertions.assertEquals("You saved the account information.", changedPasswordAlertText);
    }
}
