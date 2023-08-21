package luma.pages;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//a[@class='product-item-link']")
    private WebElement foundItemName;

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    public String getProductItemName() {
        String itemName = foundItemName.getText();
        return itemName;
    }
}
