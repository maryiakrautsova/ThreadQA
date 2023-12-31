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
public class CompareMenTopsTest extends BaseSeleniumTest {
    private static final Logger LOGGER = LogManager.getLogger(CompareMenTopsTest.class.getName());

    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Top tab from Men dropdown list, adds the 1st and the 2nd product items to " +
            "compare list, opens this list. Added product items must be present in compare list.")
    @TmsLink("test-4")
    public void compareTwoMenTopsTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        boolean areBothProductsCompared = frequentlyUsedMethods.createUser()
                .returnToMainPage()
                .chooseTopsTabFromMenDropdownList()
                .addFirstProductToCompareList()
                .addSecondProductToCompareList()
                .openCompareList()
                .areProductsToComparePresent();
        LOGGER.info(String.format("Two men tops are compared.", areBothProductsCompared));

        Assertions.assertTrue(areBothProductsCompared);
    }
}
