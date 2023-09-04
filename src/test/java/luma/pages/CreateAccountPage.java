package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(CreateAccountPage.class.getName());

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(id = "email_address")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public CustomerAccountPage createAccountAndDoNotSubscribeForNewsLetter(String firstName, String lastName,
                                                                           String email, String password,
                                                                           String confirmPassword) {
        LOGGER.debug(String.format("Attempt to input first name into First Name field: %s.", firstName));
        firstNameField.sendKeys(firstName);

        LOGGER.debug(String.format("Attempt to input last name into Last Name field: %s.", lastName));
        lastNameField.sendKeys(lastName);

        LOGGER.debug(String.format("Attempt to input email into Email field: %s.", email));
        emailField.sendKeys(email);

        LOGGER.debug(String.format("Attempt to input password into Password field: %s.", password));
        passwordField.sendKeys(password);

        LOGGER.debug(String.format("Attempt to input confirm password into Confirm Password field: %s.", confirmPassword));
        confirmPasswordField.sendKeys(confirmPassword);

        LOGGER.debug(String.format("Attempt to click on Create An Account button.", createAnAccountButton));
        createAnAccountButton.click();
        return new CustomerAccountPage();
    }
}
