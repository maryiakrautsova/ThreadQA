package luma.tests;

import com.github.javafaker.Faker;
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
public class PurchaseProductItemTest extends BaseSeleniumTest {
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Bags tab from Gear dropdown list, adds the 1st product item to the cart, " +
            "fills in Shipping form and clicks Place Order button. Continue button is present.")
    public void makePurchaseTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        frequentlyUsedMethods.createUser();
        String userFirstName = Faker.instance().name().firstName();
        String userLastName = Faker.instance().name().lastName();

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
        Assertions.assertTrue(continueButtonIsPresent);
    }
}
