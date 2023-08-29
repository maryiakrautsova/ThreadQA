package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class ChangePasswordTest extends BaseSeleniumTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, clicks Change Password link, fills in Change Password fields and presses Save button." +
            "Changed password alert is present.")
    @TmsLink("test-3")
    public void changePasswordTest() {
        String newUserPassword = Faker.instance().internet().password(10, 15,
                true, true);
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String userPassword = frequentlyUsedMethods.getPassword();

        String changedPasswordAlertText = frequentlyUsedMethods.createUser()
                .clickChangePasswordLink()
                .fillInChangePasswordFieldsAndSave(userPassword, newUserPassword)
                .changedPasswordAlertPoppedUpMessage();
        Assertions.assertEquals("You saved the account information.", changedPasswordAlertText);
    }
}
