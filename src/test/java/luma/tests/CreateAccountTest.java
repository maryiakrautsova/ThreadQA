package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Owner;
import luma.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class CreateAccountTest extends BaseSeleniumTest {
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("Main page is opened, Create Account button is clicked, fills in all fields and clicks Create An " +
            "Account button. Created account name must be present.")
    @Flaky
    public void createAccountTest() {
        String firstName = Faker.instance().name().firstName();
        String lastName = Faker.instance().name().lastName();
        String email = Faker.instance().internet().emailAddress();
        String password = Faker.instance().internet().password(10, 15,
                true, true);
        MainPage mainPage = new MainPage();
        String myAccountName = mainPage.clickCreateAnAccountLink()
                .createAccountAndDoNotSubscribeForNewsLetter(firstName, lastName, email, password, password)
                .getMyAccountName();

        Assertions.assertEquals("My Account", myAccountName);
    }
}
