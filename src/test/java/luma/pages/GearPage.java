package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GearPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(GearPage.class.getName());

    @FindBy(css = ".products .product-items li:first-child")
    private WebElement firstBag;

    @FindBy(css = ".products .product-items li:nth-child(2)")
    private WebElement secondFitnessEquipment;

    @FindBy(xpath = "(//a[@title='Add to Wish List'])[2]")
    private WebElement addToWishListSecondFitnessEquipment;

    @FindBy(xpath = "(//button[@title='Add to Cart'])[1]")
    private WebElement addToCartFirstItemButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartButton;

    @FindBy(id = "top-cart-btn-checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//div[@data-role='title' and text()='Price']")
    private WebElement priceTab;

    @FindBy(xpath = "//span[text()='$20.00']")
    private WebElement priceTwentyToThirtyDollarsFilter;

    public GearPage() {
        PageFactory.initElements(driver, this);
    }

    public ShippingPage addFirstBagToCart() throws InterruptedException {

        LOGGER.debug(String.format("Navigation to the first bag item.", firstBag));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstBag).perform();

        LOGGER.debug(String.format("Attempt to click on Add To Cart button.", addToCartFirstItemButton));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToCartFirstItemButton)).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        Thread.sleep(3000);

        LOGGER.debug(String.format("Attempt to click on Cart button.", cartButton));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                cartButton)).click();

        LOGGER.debug(String.format("Attempt to click on Proceed To Checkout button.", proceedToCheckoutButton));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                proceedToCheckoutButton)).click();

        return new ShippingPage();
    }

    public MyWishListPage addSecondProductToWishList() throws InterruptedException {
        LOGGER.debug(String.format("Navigation to the second fitness equipment item.", secondFitnessEquipment));

        Actions actions = new Actions(driver);
        actions.moveToElement(secondFitnessEquipment).perform();

        LOGGER.debug(String.format("Attempt to add to wish list the second fitness equipment.",
                addToWishListSecondFitnessEquipment));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToWishListSecondFitnessEquipment)).click();

        LOGGER.debug(String.format("Attempt to click Cart button.", cartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        Thread.sleep(3000);

        return new MyWishListPage();
    }

    public FirstGearBagPage clickTheFirstBag() {
        LOGGER.debug(String.format("Attempt to click on the first bag item.", firstBag));

        firstBag.click();
        return new FirstGearBagPage();
    }

    public ProductItemsPriceFromTwentyToThirtyDollarsPage filterPriceTwentyToThirty() {
        LOGGER.debug(String.format("Attempt to click on Price tab.", priceTab));
        priceTab.click();

        LOGGER.debug(String.format("Attempt to filter prices $20-29.", priceTwentyToThirtyDollarsFilter));
        priceTwentyToThirtyDollarsFilter.click();
        return new ProductItemsPriceFromTwentyToThirtyDollarsPage();
    }
}
