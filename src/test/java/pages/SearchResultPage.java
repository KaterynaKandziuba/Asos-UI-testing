package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']")
    private List<WebElement> searchResultProductsListText;

    @FindBy(xpath = "//a[@data-auto-id = 'loadMoreProducts']")
    private WebElement loadMoreButton;

    @FindBy(xpath = "//div[@data-auto-id='productTileDescription']//p[contains(text(), 'Missguided oversized shirt')]")
    private WebElement dressButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResultsList() {
        return searchResultProductsListText;
    }

    public void clickLoadMoreButton() {
        loadMoreButton.click();
    }

    public void clickDressButton() {
        dressButton.click();
    }

}
