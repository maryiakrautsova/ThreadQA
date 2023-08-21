package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessOrderPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@class='action primary continue']")
    private WebElement continueShoppingButton;

    public SuccessOrderPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isContinueButtonPresent() {
        try {
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOf(continueShoppingButton)
            );
            return continueShoppingButton.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}
