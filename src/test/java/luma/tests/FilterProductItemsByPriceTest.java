package luma.tests;

import core.BaseSeleniumTest;
import core.TestListener;
import helpers.FrequentlyUsedMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class FilterProductItemsByPriceTest extends BaseSeleniumTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Bags tab from Gear dropdown list, sets filter 20-29$, gets filtered product " +
            "item price. Price must be equal to $24.00.")
    public void filterBagsByPriceTest() {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String filteredProductItemPrice = frequentlyUsedMethods.createUser()
                .returnToMainPage()
                .chooseBagsTabFromGearDropdownList()
                .filterPriceTwentyToThirty()
                .getFilteredProductItemPrice();
        Assertions.assertEquals("$24.00", filteredProductItemPrice);
    }
}
