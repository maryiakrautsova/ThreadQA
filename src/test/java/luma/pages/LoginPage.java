package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement changedPasswordAlert;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public CustomerAccountPage signInUser(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        sendButton.click();
        return new CustomerAccountPage();
    }

    public String changedPasswordAlertPoppedUpMessage() {

        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOf(changedPasswordAlert));
        return changedPasswordAlert.getText();
    }
}
