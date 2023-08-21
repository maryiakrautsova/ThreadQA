package helpers;

import com.github.javafaker.Faker;
import core.BaseSeleniumPage;

import luma.pages.CustomerAccountPage;
import luma.pages.MainPage;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FrequentlyUsedMethods extends BaseSeleniumPage {
    private String password = Faker.instance().internet().password(10, 15,
            true, true);
    private String email = Faker.instance().internet().emailAddress();

    public FrequentlyUsedMethods() {
        PageFactory.initElements(driver, this);
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public CustomerAccountPage createUser() {
        MainPage mainPage = new MainPage();
        mainPage.clickCreateAnAccountLink().createAccountAndDoNotSubscribeForNewsLetter(
                Faker.instance().name().firstName(),
                Faker.instance().name().lastName(),
                email,
                password,
                password);
        return new CustomerAccountPage();
    }

    public void loginUser(String email, String password) {
        MainPage mainPage = new MainPage();
        mainPage.clickSignInLink().signInUser(email, password);
    }


    public void logoutUser() throws InterruptedException {
        CustomerAccountPage customerAccountPage = new CustomerAccountPage();
        customerAccountPage.clickToSelectSignOut().selectSignOut();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void createUserAndSignOut() throws InterruptedException {
        createUser();
        logoutUser();
    }
}
