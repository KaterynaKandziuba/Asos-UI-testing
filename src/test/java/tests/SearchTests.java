package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends BaseTest {

    private static final String SEARCH_KEYWORD = "dress";
    public String SEARCH_RESULT = "q=dress";

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(SEARCH_RESULT));
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD);
        getBasePage().waitForLoadPageComplete(30);
        Assert.assertEquals(getSearchResultPage().getSearchResultsList().size(), 72);
    }

    @Test(priority = 3)
    public void checkThatSearchResultsContainSearchWord() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD);
        for (WebElement webElement : getSearchResultPage().getSearchResultsList()) {
            boolean itemContainsSearchKeyword;
            if (webElement.getText().contains("dress") || webElement.getText().contains("Dress")) {
                itemContainsSearchKeyword = true;
            } else {
                itemContainsSearchKeyword = false;
            }
            Assert.assertTrue(itemContainsSearchKeyword);
        }
    }

    @Test(priority = 4)
    public void checkLoadingProductsViaLoadMore() {
        getHomePage().searchByKeywords(SEARCH_KEYWORD);
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickLoadMoreButton();
        getBasePage().waitForLoadPageComplete(30);
        int ACTUAL_NUMBER_OF_ITEMS = getSearchResultPage().getSearchResultsList().size();
        Assert.assertEquals(ACTUAL_NUMBER_OF_ITEMS, 144);
    }

}






