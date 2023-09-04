package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readProperties.ConfigProvider;


public class MainPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());

    @FindBy(linkText = "Create an Account")
    private WebElement createAnAccountLink;

    @FindBy(xpath = "//div[@class='panel header']//li[@class='authorization-link']")
    private WebElement signInLink;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@class='logo']")
    private WebElement logoButton;

    @FindBy(xpath = "//button[@title='Search']")
    private WebElement searchButton;

    @FindBy(id = "ui-id-6")
    private WebElement gearDropdownList;

    @FindBy(id = "ui-id-5")
    private WebElement menDropdownList;

    @FindBy(id = "ui-id-17")
    private WebElement menTopsDropdownList;

    @FindBy(id = "ui-id-25")
    private WebElement bags;

    @FindBy(id = "ui-id-26")
    private WebElement fitnessEquipment;

    public MainPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s.", ConfigProvider.URL));

        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage clickCreateAnAccountLink() {
        LOGGER.debug(String.format("Attempt to click on Create An Account Link.", createAnAccountLink));

        createAnAccountLink.click();
        return new CreateAccountPage();
    }

    public LoginPage clickSignInLink() {
        LOGGER.debug(String.format("Attempt to click on Sign In Link.", signInLink));

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        return new LoginPage();
    }


    public boolean isSignInLinkVisible() {
        LOGGER.debug(String.format("Check whether Sign In link is visible or not: %s.", signInLink));

        try {
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(signInLink)
            );
            return signInLink.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }

    public SearchResultsPage inputSearchNameAndClickSearchButton(String itemToBeSearched) {
        LOGGER.debug(String.format("Input name of the item to be searched" + itemToBeSearched +
                " into Search field: %s.", searchField));

        searchField.sendKeys(itemToBeSearched);

        LOGGER.debug(String.format("Attempt to click on Search button: %s.", searchButton));

        searchButton.click();
        return new SearchResultsPage();
    }

    public GearPage chooseBagsTabFromGearDropdownList() {
        LOGGER.debug(String.format("Attempt to open Gear dropdown list: %s.", gearDropdownList));

        Actions action = new Actions(driver);
        action.moveToElement(gearDropdownList).perform();

        LOGGER.debug(String.format("Attempt to click on Bags option: %s.", bags));

        bags.click();
        return new GearPage();
    }

    public GearPage chooseFitnessEquipmentTabFromGearDropdownList() {
        LOGGER.debug(String.format("Attempt to open Gear dropdown list: %s.", gearDropdownList));

        Actions action = new Actions(driver);
        action.moveToElement(gearDropdownList).perform();

        LOGGER.debug(String.format("Attempt to click on Fitness Equipment option: %s.", fitnessEquipment));

        fitnessEquipment.click();
        return new GearPage();
    }

    public MenTopsPage chooseTopsTabFromMenDropdownList() {
        LOGGER.debug(String.format("Attempt to open Men dropdown list: %s.", menDropdownList));

        Actions action = new Actions(driver);
        action.moveToElement(menDropdownList).perform();

        LOGGER.debug(String.format("Attempt to click on Men Tops option: %s.", menTopsDropdownList));

        menTopsDropdownList.click();
        return new MenTopsPage();
    }

}
