package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BaseSeleniumPage {
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

    @FindBy(xpath = "//input[@name='is_subscribed']")
    private WebElement signUpForNewsletterCheckbox;

    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public CustomerAccountPage createAccountAndDoNotSubscribeForNewsLetter(String firstName, String lastName,
                                                                         String email, String password,
                                                                         String confirmPassword) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        createAnAccountButton.click();
        return new CustomerAccountPage();
    }
}
