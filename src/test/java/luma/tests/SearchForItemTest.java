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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class SearchForItemTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(SearchForItemTest.class.getName());

    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, inputs name of the item to be searched and clicks Search button on the Main page. " +
            "Found product item name must equal to the name of item which was searched.")
    @TmsLink("test-10")
    public void searchForItemTest() throws InterruptedException {
        String itemToBeSearched = "Zing Jump Rope";
        LOGGER.info(String.format("Generate name of item to be searched.", itemToBeSearched));


        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String itemName = frequentlyUsedMethods.createUser()
                .returnToMainPage().inputSearchNameAndClickSearchButton(itemToBeSearched)
                .getProductItemName();

        LOGGER.info(String.format("Found product item actual name.", itemName));

        Assertions.assertEquals(itemToBeSearched, itemName);
    }

}
