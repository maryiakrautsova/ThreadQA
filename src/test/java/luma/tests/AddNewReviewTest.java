package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import luma.pages.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;


@ExtendWith(TestListener.class)
public class AddNewReviewTest extends BaseSeleniumTest {

    private static final Logger LOGGER= LogManager.getLogger(AddNewReviewTest.class.getName());

    @Test
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User isn't logged in, chooses Bags tab from Gear dropdown list, clicks on th 1st one, " +
            "sets 5 stars rating and leaves a text, presses Submit button. Submission alert must be present.")
    @TmsLink("test-1")
    public void addNewReviewTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Main Page %s is initialized.", MainPage.class.getName()));

        String nickName = Faker.instance().name().firstName();
        LOGGER.debug(String.format("Generation of a new nickname: %s", nickName));

        String summary = String.valueOf(Faker.instance().book().title());
        LOGGER.debug(String.format("Generation of a summary text: %s", summary));
        String review = String.valueOf(Faker.instance().lorem().paragraph());
        LOGGER.debug(String.format("Generation of a review text: %s", review));
        LOGGER.info("Check submission alert (review text is created) is present.");
        boolean submissionAlertIsPresent = mainPage.chooseBagsTabFromGearDropdownList()
                .clickTheFirstBag()
                .addFiveStarsRatingReviewForProductAndSubmit(nickName, summary, review)
                .isSubmittedReviewAlertPoppedUp();

        Assertions.assertTrue(submissionAlertIsPresent);
    }
}
