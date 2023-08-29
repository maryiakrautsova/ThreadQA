package luma.tests;

import com.github.javafaker.Faker;
import core.BaseSeleniumTest;
import core.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import luma.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;

@ExtendWith(TestListener.class)
public class AddNewReviewTest extends BaseSeleniumTest {
    @Test
    @RetryingTest(3)
    @Owner("Maria Kravtsova")
    @Description("User isn't logged in, chooses Bags tab from Gear dropdown list, clicks on th 1st one, " +
            "sets 5 stars rating and leaves a text, presses Submit button. Submission alert must be present.")
    @TmsLink("test-1")
    public void addNewReviewTest() {
        MainPage mainPage = new MainPage();
        String nickName = Faker.instance().name().firstName();

        String summary = String.valueOf(Faker.instance().book().title());
        String review = String.valueOf(Faker.instance().lorem().paragraph());
        boolean submissionAlertIsPresent = mainPage.chooseBagsTabFromGearDropdownList()
                .clickTheFirstBag()
                .addFiveStarsRatingReviewForProductAndSubmit(nickName, summary, review)
                .isSubmittedReviewAlertPoppedUp();
        Assertions.assertTrue(submissionAlertIsPresent);
    }
}
