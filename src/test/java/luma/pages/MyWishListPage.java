package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage extends BaseSeleniumPage {
    @FindBy(xpath = "(//span[@class='toolbar-number'])[1]")
    private WebElement amountOfAddedToWishListItems;

    public MyWishListPage() {
        PageFactory.initElements(driver, this);
    }

    public String returnAmountOfAddedToWishListItems() {
        String amount = amountOfAddedToWishListItems.getText();
        return amount;
    }
}
