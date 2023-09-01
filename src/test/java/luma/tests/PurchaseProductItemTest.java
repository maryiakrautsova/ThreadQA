package luma.tests;

import com.github.javafaker.Faker;
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
public class PurchaseProductItemTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(PurchaseProductItemTest.class.getName());

    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Bags tab from Gear dropdown list, adds the 1st product item to the cart, " +
            "fills in Shipping form and clicks Place Order button. Continue button is present.")
    @TmsLink("test-9")
    public void makePurchaseTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();

        LOGGER.info(String.format("Attempt to create a new user."));
        frequentlyUsedMethods.createUser();

        String userFirstName = Faker.instance().name().firstName();
        LOGGER.info(String.format("Generation of user first name.", userFirstName));

        String userLastName = Faker.instance().name().lastName();
        LOGGER.info(String.format("Generation of user last name.", userLastName));

        CustomerAccountPage customerAccountPage = new CustomerAccountPage();

        boolean continueButtonIsPresent = customerAccountPage
                .returnToMainPage()
                .chooseBagsTabFromGearDropdownList()
                .addFirstBagToCart()
                .fillInShippingForm(userFirstName, userLastName, Faker.instance().company().name(),
                        Faker.instance().address().streetAddress(), Faker.instance().address().city(),
                        Faker.instance().address().zipCodeByState("CA"),
                        String.valueOf(Faker.instance().phoneNumber()))
                .clickPlaceOrderButton().
                isContinueButtonPresent();

        LOGGER.info(String.format("Continue button is present.", continueButtonIsPresent));

        Assertions.assertTrue(continueButtonIsPresent);
    }
}
