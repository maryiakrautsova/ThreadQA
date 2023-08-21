package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstGearBagPage extends BaseSeleniumPage {

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
        reviewsTab.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.document.getElementById('Rating_5_label').click()");

        nicknameField.sendKeys(nickname);
        summaryField.sendKeys(summary);
        reviewField.sendKeys(review);
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOf(submitReviewButton)).click();
        return this;
    }

    public boolean isSubmittedReviewAlertPoppedUp() {
        try {
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.visibilityOf(submittedReviewAlert)
            );
            return submittedReviewAlert.isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }
}
