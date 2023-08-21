package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PaymentPage extends BaseSeleniumPage {

    @FindBy(xpath = "//form[@id='co-payment-form']//button[@class='action primary checkout' and @type='submit']")
    private WebElement placeOrderButton;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public SuccessOrderPage clickPlaceOrderButton() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);


        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                placeOrderButton));
        placeOrderButton.submit();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();
        return new SuccessOrderPage();
    }
}
