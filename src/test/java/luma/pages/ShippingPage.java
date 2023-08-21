package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BaseSeleniumPage {

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='company']")
    private WebElement companyField;

    @FindBy(xpath = "//div[@name='shippingAddress.street.0']//div//input")
    private WebElement addressField;

    @FindBy(xpath = "(//select[@class='select'])[2]")
    private WebElement countryListField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "(//select[@class='select'])[1]")
    private WebElement stateList;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='postcode']")
    private WebElement postalCodeField;


    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='telephone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    private WebElement flatShippingMethod;

    @FindBy(xpath = "//button[@class='button action continue primary']")
    private WebElement nextButton;

    public ShippingPage() {
        PageFactory.initElements(driver, this);
    }

    public PaymentPage fillInShippingForm(String firstName, String lastName, String company,
                                          String streetAddress, String city, String postalCode, String phone) {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(firstNameField)).clear();
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        companyField.sendKeys(company);
        Select select = new Select(countryListField);
        select.selectByValue("US");
        Select sel = new Select(stateList);
        sel.selectByValue("12");
        addressField.sendKeys(streetAddress);
        cityField.sendKeys(city);
        postalCodeField.sendKeys(postalCode);
        phoneNumberField.sendKeys(phone);
        flatShippingMethod.click();
        nextButton.click();
        return new PaymentPage();
    }
}
