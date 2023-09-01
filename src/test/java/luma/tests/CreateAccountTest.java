package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import luma.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class CreateAccountTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateAccountTest.class.getName());

    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("Main page is opened, Create Account button is clicked, fills in all fields and clicks Create An " +
            "Account button. Created account name must be present.")
    @TmsLink("test-5")
    @Flaky
    public void createAccountTest() {
        String firstName = Faker.instance().name().firstName();
        LOGGER.info(String.format("First name is generated.", firstName));

        String lastName = Faker.instance().name().lastName();
        LOGGER.info(String.format("Last name is generated.", lastName));

        String email = Faker.instance().internet().emailAddress();
        LOGGER.info(String.format("Email is generated.", email));

        String password = Faker.instance().internet().password(10, 15,
                true, true);
        LOGGER.info(String.format("Password is generated.", password));

        MainPage mainPage = new MainPage();
        String myAccountName = mainPage.clickCreateAnAccountLink()
                .createAccountAndDoNotSubscribeForNewsLetter(firstName, lastName, email, password, password)
                .getMyAccountName();

        LOGGER.info(String.format("Attempt to get actual account name.", myAccountName));

        Assertions.assertEquals("My Account", myAccountName);
    }
}
