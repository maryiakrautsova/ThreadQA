package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductItemsPriceFromTwentyToThirtyDollarsPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(ProductItemsPriceFromTwentyToThirtyDollarsPage.class
            .getName());

    @FindBy(id = "product-price-10")
    private WebElement priceOfProductItem;

    public ProductItemsPriceFromTwentyToThirtyDollarsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getFilteredProductItemPrice() {
        LOGGER.debug(String.format("Get price of product item.", priceOfProductItem));

        return priceOfProductItem.getText();
    }
}
