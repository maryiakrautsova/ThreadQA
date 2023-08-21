package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductItemsPriceFromTwentyToThirtyDollarsPage extends BaseSeleniumPage {

    @FindBy(id = "product-price-10")
    private WebElement priceOfProductItem;

    public ProductItemsPriceFromTwentyToThirtyDollarsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getFilteredProductItemPrice() {
        return priceOfProductItem.getText();
    }
}
