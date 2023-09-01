package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PaymentPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(PaymentPage.class.getName());

    @FindBy(xpath = "//form[@id='co-payment-form']//button[@class='action primary checkout' and @type='submit']")
    private WebElement placeOrderButton;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public SuccessOrderPage clickPlaceOrderButton() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        LOGGER.debug(String.format("Attempt to submit Place Order button.",
                placeOrderButton));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                placeOrderButton));
        placeOrderButton.submit();

        LOGGER.debug(String.format("Attempt to click Place Order button.",
                placeOrderButton));
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
        return new SuccessOrderPage();
    }
}
