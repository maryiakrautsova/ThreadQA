package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstGearBagPage extends BaseSeleniumPage {

    private static final Logger LOGGER = LogManager.getLogger(FirstGearBagPage.class.getName());

    @FindBy(id = "tab-label-reviews-title")
    private WebElement reviewsTab;

    @FindBy(id = "Rating_5_label")
    private WebElement fiveStarsRating;

    @FindBy(id = "nickname_field")
    private WebElement nicknameField;

    @FindBy(id = "summary_field")
    private WebElement summaryField;

    @FindBy(id = "review_field")
    private WebElement reviewField;

    @FindBy(xpath = "//form[@id='review-form']//button[@class='action submit primary' and @type='submit']")
    private WebElement submitReviewButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement submittedReviewAlert;

    public FirstGearBagPage() {
        PageFactory.initElements(driver, this);
    }

    public FirstGearBagPage addFiveStarsRatingReviewForProductAndSubmit(String nickname, String summary, String review) {

        LOGGER.debug(String.format("Attempt to click on Reviews tab.", reviewsTab));
        reviewsTab.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.document.getElementById('Rating_5_label').click()");

        LOGGER.debug(String.format("Attempt to input nickname" + nickname + " into Nickname field: %s.", nicknameField));
        nicknameField.sendKeys(nickname);

        LOGGER.debug(String.format("Attempt to input summary" + summary + " into Summary field: %s.", summaryField));
        summaryField.sendKeys(summary);

        LOGGER.debug(String.format("Attempt to input review text" + review + " into Review field: %s.", reviewField));
        reviewField.sendKeys(review);

        LOGGER.debug(String.format("Attempt to click Submit button: %s.", submitReviewButton));
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOf(submitReviewButton)).click();
        return this;
    }

    public boolean isSubmittedReviewAlertPoppedUp() {
        LOGGER.debug(String.format("Attempt to get text of successfully submitted review's alert: %s",
                submittedReviewAlert));

        try {
            new WebDriverWait(driver, 50).until(
                    ExpectedConditions.visibilityOf(submittedReviewAlert)
            );
            return submittedReviewAlert.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}
