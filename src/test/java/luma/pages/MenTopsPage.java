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

public class MenTopsPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(MenTopsPage.class.getName());

    @FindBy(css = ".products .product-items li:first-child")
    private WebElement firstMenTop;

    @FindBy(css = ".products .product-items li:nth-child(2)")
    private WebElement secondMenTop;

    @FindBy(xpath = "(//a[@title='Add to Compare'])[1]")
    private WebElement addToCompareFirstProductItem;

    @FindBy(xpath = "(//a[@title='Add to Compare'])[2]")
    private WebElement addToCompareSecondProductItem;

    @FindBy(linkText = "comparison list")
    private WebElement comparisonList;

    public MenTopsPage() {
        PageFactory.initElements(driver, this);
    }

    public MenTopsPage addFirstProductToCompareList() throws InterruptedException {
        LOGGER.debug(String.format("Navigation to the first men top item.", firstMenTop));

        Actions actions = new Actions(driver);
        actions.moveToElement(firstMenTop).perform();

        LOGGER.debug(String.format("Attempt to click Add To Compare the first product item.",
                addToCompareFirstProductItem));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToCompareFirstProductItem)).click();

        return this;
    }

    public MenTopsPage addSecondProductToCompareList() throws InterruptedException {
        LOGGER.debug(String.format("Navigation to the second men top item.", secondMenTop));

        Actions actions = new Actions(driver);
        actions.moveToElement(secondMenTop).perform();

        LOGGER.debug(String.format("Attempt to click Add To Compare the second product item.",
                addToCompareSecondProductItem));
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(
                addToCompareSecondProductItem)).click();

        return this;
    }

    public ProductComparePage openCompareList() {
        LOGGER.debug(String.format("Attempt to open comparison list.",
                comparisonList));

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions
                        .visibilityOf(comparisonList)).click();
        return new ProductComparePage();
    }
}
