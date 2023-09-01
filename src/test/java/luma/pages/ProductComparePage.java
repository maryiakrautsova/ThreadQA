package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductComparePage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(ProductComparePage.class.getName());

    @FindBy(xpath = "(//td[@data-th='Product'])[1]")
    private WebElement productOne;

    @FindBy(xpath = "(//td[@data-th='Product'])[2]")
    private WebElement productTwo;

    public ProductComparePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean areProductsToComparePresent() {
        LOGGER.debug(String.format("Product item one " + productOne + " and product item two " + productTwo +
                " are chosen."));
        try {
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOf(productOne)
            );
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOf(productTwo)
            );
            return productOne.isDisplayed() && productTwo.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}
