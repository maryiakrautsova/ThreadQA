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
public class FilterProductItemsByPriceTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(FilterProductItemsByPriceTest.class.getName());

    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Bags tab from Gear dropdown list, sets filter 20-29$, gets filtered product " +
            "item price. Price must be equal to $24.00.")
    @TmsLink("test-6")
    public void filterBagsByPriceTest() {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String filteredProductItemPrice = frequentlyUsedMethods.createUser()
                .returnToMainPage()
                .chooseBagsTabFromGearDropdownList()
                .filterPriceTwentyToThirty()
                .getFilteredProductItemPrice();

        LOGGER.info(String.format("Attempt to get actual filtered product item's price.", filteredProductItemPrice));

        Assertions.assertEquals("$24.00", filteredProductItemPrice);
    }
}
