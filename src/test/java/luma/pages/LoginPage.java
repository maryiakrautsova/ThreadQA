package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

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
        LOGGER.debug(String.format("Attempt to input email into Email field: %s.", email));
        emailField.sendKeys(email);

        LOGGER.debug(String.format("Attempt to input password into Password field: %s.", password));
        passwordField.sendKeys(password);


        LOGGER.debug(String.format("Attempt to click on Send button.", sendButton));
        sendButton.click();
        return new CustomerAccountPage();
    }

    public String changedPasswordAlertPoppedUpMessage() {
        LOGGER.debug(String.format("Attempt to get text of successfully changed password: %s", changedPasswordAlert));

        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOf(changedPasswordAlert));
        return changedPasswordAlert.getText();
    }
}
