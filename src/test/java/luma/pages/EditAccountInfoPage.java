package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditAccountInfoPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(EditAccountInfoPage.class.getName());

    @FindBy(id = "current-password")
    private WebElement currentPasswordField;

    @FindBy(id = "password")
    private WebElement newPasswordField;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    public EditAccountInfoPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage fillInChangePasswordFieldsAndSave(String currentPass, String newPass) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(
                currentPasswordField)).sendKeys(currentPass);
        newPasswordField.sendKeys(newPass);
        confirmPasswordField.sendKeys(newPass);
        saveButton.click();
        return new LoginPage();
    }
}
