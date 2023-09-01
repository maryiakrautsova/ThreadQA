package luma.pages;

import core.BaseSeleniumPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BaseSeleniumPage {
    private static final Logger LOGGER = LogManager.getLogger(SearchResultsPage.class.getName());


    @FindBy(xpath = "//a[@class='product-item-link']")
    private WebElement foundItemName;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getProductItemName() {
        LOGGER.debug(String.format("Get the found product item name.", foundItemName));

        String itemName = foundItemName.getText();
        return itemName;
    }
}
