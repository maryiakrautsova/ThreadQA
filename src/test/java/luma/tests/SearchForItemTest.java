package luma.tests;

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
public class SearchForItemTest extends BaseSeleniumTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, inputs name of the item to be searched and clicks Search button on the Main page. " +
            "Found product item name must equal to the name of item which was searched.")
    @TmsLink("test-10")
    public void searchForItemTest() throws InterruptedException {
        String itemToBeSearched = "Zing Jump RopeLL";

        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String itemName = frequentlyUsedMethods.createUser()
                .returnToMainPage().inputSearchNameAndClickSearchButton(itemToBeSearched)
                .getProductItemName();

        Assertions.assertEquals(itemToBeSearched, itemName);
    }

}
