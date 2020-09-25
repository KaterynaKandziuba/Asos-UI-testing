package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class AddToBagTests extends BaseTest {

    private static final String EXPECTED_SELECTION_SIZE_ERROR = "Please select from the available colour and size options";
    private static final String EXPECTED_AMOUNT_OF_PRODUCT_IN_BAG = "1";
    private static final String EXPECTED_LOGIN_FORM_URL = "login?signin";
    private static final String EXPECTED_AMOUNT_OF_ITEMS_IN_BAG = "2";

    @Test(priority = 5)
    public void checkAddToBagWithoutSize() {
        getHomePage().clickWomenProductsButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getTablist());
        getHomePage().clickClothingButton();
        getHomePage().clickDressesButton();
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickDressButton();
        getBasePage().waitForLoadPageComplete(30);
        String dressPageUrl = getDriver().getCurrentUrl();
        getDressPage().clickAddToBagButton();
        Assert.assertEquals(getDriver().getCurrentUrl(), dressPageUrl);

        getBasePage().waitVisibilityOfElement(10, getDressPage().getSelectSizeErrorAppearance());
        String ACTUAL_SELECTION_SIZE_ERROR = getDressPage().getSelectSizeErrorAppearanceText();
        Assert.assertEquals(ACTUAL_SELECTION_SIZE_ERROR, EXPECTED_SELECTION_SIZE_ERROR);
    }

    @Test(priority = 6)
    public void checkAddToBag() {
        getHomePage().clickWomenProductsButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getTablist());
        getHomePage().clickClothingButton();
        getHomePage().clickDressesButton();
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickDressButton();
        getBasePage().waitForLoadPageComplete(30);
        getDressPage().clickSelectSizeButton();
        getDressPage().clickSelectSizeOption();
        getDressPage().clickAddToBagButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getMiniBagPopup());
        Assert.assertEquals(getHomePage().getAmountOfProductInBag(), EXPECTED_AMOUNT_OF_PRODUCT_IN_BAG);
    }

    @Test(priority = 7)
    public void checkBuyFromMiniBagPopup() {
        getHomePage().clickWomenProductsButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getTablist());
        getHomePage().clickClothingButton();
        getHomePage().clickDressesButton();
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickDressButton();
        getBasePage().waitForLoadPageComplete(30);
        getDressPage().clickSelectSizeButton();
        getDressPage().clickSelectSizeOption();
        getDressPage().clickAddToBagButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getMiniBagPopup());
        getHomePage().clickPopupCheckoutButton();
        getBasePage().waitForLoadPageComplete(30);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_LOGIN_FORM_URL));
    }

    @Test(priority = 8)
    public void checkAddToBagTwoIdenticalProducts() {
        getHomePage().clickWomenProductsButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getTablist());
        getHomePage().clickClothingButton();
        getHomePage().clickDressesButton();
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickDressButton();
        getBasePage().waitForLoadPageComplete(30);
        getDressPage().clickSelectSizeButton();
        getBasePage().waitVisibilityOfElement(10, getDressPage().getSelectSizeOption());
        getDressPage().clickSelectSizeOption();
        getDressPage().clickAddToBagButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getMiniBagPopup());
        getHomePage().clickPopupViewBagButton();
        getBasePage().waitForLoadPageComplete(30);
        getMyBagPage().clickIncreaseQuantityOfGoods();
        getMyBagPage().clickDoubleQuantityOfGoodsOption();
        getBasePage().waitVisibilityOfElement(10, getMyBagPage().getItemUpdateButton());
        getMyBagPage().clickItemUpdateButton();
        Assert.assertTrue(getMyBagPage().getQuantityOfGoodsInBag().contains(EXPECTED_AMOUNT_OF_ITEMS_IN_BAG));
    }

    @Test(priority = 9)
    public void checkDeleteFromBagItems() {
        getHomePage().clickWomenProductsButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getTablist());
        getHomePage().clickClothingButton();
        getHomePage().clickDressesButton();
        getBasePage().waitForLoadPageComplete(30);
        getSearchResultPage().clickDressButton();
        getBasePage().waitForLoadPageComplete(30);
        getDressPage().clickSelectSizeButton();
        getBasePage().waitVisibilityOfElement(10, getDressPage().getSelectSizeOption());
        getDressPage().clickSelectSizeOption();
        getDressPage().clickAddToBagButton();
        getBasePage().waitVisibilityOfElement(10, getHomePage().getMiniBagPopup());
        getHomePage().clickPopupViewBagButton();
        getBasePage().implicitWait(30);
        getMyBagPage().clickDeliveryButton();
        getMyBagPage().clickExpressDeliveryButton();
        getMyBagPage().clickTotalCheckoutButton();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_LOGIN_FORM_URL));
    }


}
