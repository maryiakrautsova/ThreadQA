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
public class AddProductItemToWishListTest extends BaseSeleniumTest {
    @Test
    @Owner("Maria Kravtsova")
    @Description("User is logged in, chooses Fitness Equipment tab from Gear dropdown list, adds the 2nd product item to" +
            "his wish list. Amount of added to wish list product items must equal to 1.")
    public void addProductItemToWishListTest() throws InterruptedException {
        FrequentlyUsedMethods frequentlyUsedMethods = new FrequentlyUsedMethods();
        String itemIsAddedConfirmation = frequentlyUsedMethods.createUser()
                .returnToMainPage()
                .chooseFitnessEquipmentTabFromGearDropdownList()
                .addSecondProductToWishList()
                .returnAmountOfAddedToWishListItems();

        Assertions.assertEquals("1 Item", itemIsAddedConfirmation);
    }
}