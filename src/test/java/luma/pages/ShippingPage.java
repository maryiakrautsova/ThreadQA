package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(ShippingPage.class.getName());

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='company']")
    private WebElement companyField;

    @FindBy(xpath = "//div[@name='shippingAddress.street.0']//div//input")
    private WebElement addressField;

    @FindBy(xpath = "//div[@name='shippingAddress.country_id']//select[@class='select']")
    private WebElement countryListField;

    @FindBy(xpath = "//form[@id='co-shipping-form']//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//div[@name='shippingAddress.region_id']//select[@class='select']")
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

        LOGGER.debug(String.format("Clear data from First Name field.", firstNameField));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(firstNameField)).clear();

        LOGGER.debug(String.format("Input first name " + firstName + " into First Name field." + firstNameField));
        firstNameField.sendKeys(firstName);

        LOGGER.debug(String.format("Clear data from Last Name field.", lastName));
        lastNameField.clear();

        LOGGER.debug(String.format("Input last name " + lastName + " into Last Name field." + lastNameField));
        lastNameField.sendKeys(lastName);

        LOGGER.debug(String.format("Input company " + company + " into Company field." + companyField));
        companyField.sendKeys(company);

        LOGGER.debug(String.format("Select country name US from country list", countryListField));
        Select select = new Select(countryListField);
        select.selectByValue("US");

        LOGGER.debug(String.format("Select state name from state list", stateList));
        Select sel = new Select(stateList);
        sel.selectByValue("12");

        LOGGER.debug(String.format("Input street " + streetAddress + " into Address field." + addressField));
        addressField.sendKeys(streetAddress);

        LOGGER.debug(String.format("Input city " + city + " into City field." + cityField));
        cityField.sendKeys(city);

        LOGGER.debug(String.format("Input code " + postalCode + " into Postal Code field." + postalCodeField));
        postalCodeField.sendKeys(postalCode);

        LOGGER.debug(String.format("Input phone " + phone + " into Phone Number field." + phoneNumberField));
        phoneNumberField.sendKeys(phone);

        LOGGER.debug(String.format("Choose flat shipping method.", flatShippingMethod));
        flatShippingMethod.click();

        LOGGER.debug(String.format("Click Next button", nextButton));
        nextButton.click();
        return new PaymentPage();
    }
}
