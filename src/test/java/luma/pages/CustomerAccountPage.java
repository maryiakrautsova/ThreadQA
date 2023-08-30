package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerAccountPage extends BaseSeleniumPage {
    @FindBy(xpath = "//span[@class='base']")
    private WebElement myAccount;

    @FindBy(xpath = "(//span[@class=\"customer-name\"])[1]")
    private WebElement dropdownToSignOut;

    @FindBy(xpath = "(//a[contains(@href,'logout')])[1]")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@class='logo']")
    private WebElement logoButtonToGoToMainPage;

    @FindBy(xpath = "//a[@class='action change-password']")
    private WebElement changePasswordLink;

    public CustomerAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public String getMyAccountName() {
        return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(myAccount)).getText();
    }

    public CustomerAccountPage clickToSelectSignOut() {
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
