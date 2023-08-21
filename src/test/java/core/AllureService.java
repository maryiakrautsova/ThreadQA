package core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import static core.BaseSeleniumPage.driver;


public class AllureService {
    @Attachment
    public String getSystemName() {
        return System.getProperty("os.name");
    }

    @Attachment(value = "Browser type", type = "text/plain")
    public String getBrowserName() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        return browserName;
    }

    @Attachment(value = "Browser version", type = "text/plain")
    public String getBrowserVersion() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserVersion = caps.getVersion();
        return browserVersion;
    }
}
