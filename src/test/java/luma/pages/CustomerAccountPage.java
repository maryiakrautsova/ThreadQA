package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerAccountPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(CustomerAccountPage.class.getName());

    @FindBy(xpath = "//span[@class='base']")
    private WebElement myAccount;

    @FindBy(xpath = "//div[@class='panel header']//button[@data-action='customer-menu-toggle']")
    private WebElement dropdownToSignOut;

    @FindBy(css = ".panel .customer-menu .authorization-link a")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@class='logo']")
    private WebElement logoButtonToGoToMainPage;

    @FindBy(xpath = "//a[@class='action change-password']")
    private WebElement changePasswordLink;

    public CustomerAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public String getMyAccountName() {
        LOGGER.debug(String.format("Attempt to get account name: %s", myAccount));

        return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(myAccount)).getText();
    }

    public CustomerAccountPage clickToSelectSignOut() {
        LOGGER.debug(String.format("Attempt to click Sign Out button: %s.", dropdownToSignOut));

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(dropdownToSignOut))
                .click();
        return this;
    }

    public MainPage selectSignOut() {
        signOutLink.click();
        return new MainPage();

    }

    public MainPage returnToMainPage() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.
                        elementToBeClickable(logoButtonToGoToMainPage)).click();
        return new MainPage();
    }

    public EditAccountInfoPage clickChangePasswordLink() {
        changePasswordLink.click();
        return new EditAccountInfoPage();
    }
}
