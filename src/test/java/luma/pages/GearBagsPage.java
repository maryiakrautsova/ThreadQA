package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GearBagsPage extends BaseSeleniumPage {
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

    @FindBy(xpath = "(//div[@data-role='title'])[2]")
    private WebElement priceTab;

    @FindBy(xpath = "((//div[@class='filter-options-content'])[2]//span[@class='price'])[1]")
    private WebElement priceTwentyToThirtyDollarsFilter;

    public GearBagsPage() {
        PageFactory.initElements(driver, this);
    }

    public ShippingPage addFirstBagToCart() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(firstBag).perform();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToCartFirstItemButton)).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        Thread.sleep(3000);

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                cartButton)).click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                proceedToCheckoutButton)).click();

        return new ShippingPage();
    }

    public MyWishListPage addSecondProductToWishList() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(secondFitnessEquipment).perform();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToWishListSecondFitnessEquipment)).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartButton);
        Thread.sleep(3000);

        return new MyWishListPage();
    }

    public FirstGearBagPage clickTheFirstBag() {
        firstBag.click();
        return new FirstGearBagPage();
    }

    public ProductItemsPriceFromTwentyToThirtyDollarsPage filterPriceTwentyToThirty() {
        priceTab.click();
        priceTwentyToThirtyDollarsFilter.click();
        return new ProductItemsPriceFromTwentyToThirtyDollarsPage();
    }
}
