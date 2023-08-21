package core;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

import static core.BaseSeleniumPage.driver;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        AllureService allureService = new AllureService();
        allureService.getSystemName();
        allureService.getBrowserName();
        allureService.getBrowserVersion();
        driver.close();
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        AllureService allureService = new AllureService();
        System.err.println("SUCCESSFUL: " + context.getRequiredTestMethod().getName());
        allureService.getSystemName();
        allureService.getBrowserName();
        allureService.getBrowserVersion();
        driver.close();
        driver.quit();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        driver.close();
        driver.quit();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        driver.close();
        driver.quit();
    }
}
