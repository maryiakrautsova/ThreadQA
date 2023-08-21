package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import readProperties.ConfigProvider;


public class MainPage extends BaseSeleniumPage {
    @FindBy(linkText = "Create an Account")
    private WebElement createAnAccountLink;

    @FindBy(xpath = "(//li[@class='authorization-link'])[1]")
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
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage clickCreateAnAccountLink() {
        createAnAccountLink.click();
        return new CreateAccountPage();
    }

    public LoginPage clickSignInLink() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        return new LoginPage();
    }


    public boolean isSignInLinkVisible() {
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
        searchField.sendKeys(itemToBeSearched);
        searchButton.click();
        return new SearchResultsPage();
    }

    public GearBagsPage chooseBagsTabFromGearDropdownList() {
        Actions action = new Actions(driver);
        action.moveToElement(gearDropdownList).perform();
        bags.click();
        return new GearBagsPage();
    }

    public GearBagsPage chooseFitnessEquipmentTabFromGearDropdownList() {
        Actions action = new Actions(driver);
        action.moveToElement(gearDropdownList).perform();
        fitnessEquipment.click();
        return new GearBagsPage();
    }

    public MenTopsPage chooseTopsTabFromMenDropdownList() {
        Actions action = new Actions(driver);
        action.moveToElement(menDropdownList).perform();
        menTopsDropdownList.click();
        return new MenTopsPage();
    }

}