package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(MyWishListPage.class.getName());

    @FindBy(xpath = "(//span[@class='toolbar-number'])[1]")
    private WebElement amountOfAddedToWishListItems;

    public MyWishListPage() {
        PageFactory.initElements(driver, this);
    }

    public String returnAmountOfAddedToWishListItems() {
        LOGGER.debug(String.format("Get amount of added to Wish list product items: %s.", amountOfAddedToWishListItems));

        String amount = amountOfAddedToWishListItems.getText();
        return amount;
    }
}
