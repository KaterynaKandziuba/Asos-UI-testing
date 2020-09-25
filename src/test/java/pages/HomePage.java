package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type = 'search']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@data-testid = 'women-floor']")
    private WebElement womenProductsButton;

    @FindBy(xpath = "//nav[@aria-hidden= 'false']//div[@role = 'tablist']")
    private WebElement tablist;

    @FindBy(xpath = "//button[@data-id = '96b432e3-d374-4293-8145-b00772447cde']")
    private WebElement clothingButton;

    @FindBy(xpath = "//a[@href = 'https://www.asos.com/women/dresses/cat/?cid=8799&nlid=ww|clothing|shop+by+product']")
    private WebElement dressesButton;

    @FindBy(xpath = "//span[@class = '_1z5n7CN']")
    private WebElement amountProductsInBag;

    @FindBy(xpath = "//div[@id = 'minibag-dropdown']/div[@class = '_33s2s-y']")
    private WebElement miniBagPopup;

    @FindBy(xpath = "//a[@data-test-id = 'checkout-link']")
    private WebElement popupCheckoutButton;

    //@FindBy(xpath = "//a[@href = 'https://www.asos.com/bag?ctaref=mini%20bag']")
    @FindBy(xpath = "//div[@class = '_1uskYPE']/a[@data-test-id = 'bag-link']")
    private WebElement popupViewBagButton;

    @FindBy(xpath = "//span[@type = 'accountUnfilled']")
    private WebElement accountIconButton;

    @FindBy(xpath = "//a[@data-testid = 'myaccount-link']")
    private WebElement myAccountButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeywords(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickWomenProductsButton() {
        womenProductsButton.click();
    }

    public WebElement getTablist() {
        return tablist;
    }

    public void clickClothingButton() {
        clothingButton.click();
    }

    public void clickDressesButton() {
        dressesButton.click();
    }

    public String getAmountOfProductInBag() {
        return amountProductsInBag.getText();
    }

    public WebElement getMiniBagPopup() {
        return miniBagPopup;
    }

    public void clickPopupCheckoutButton() {
        popupCheckoutButton.click();
    }

    public void clickPopupViewBagButton() {
        popupViewBagButton.click();
    }

    public void clickAccountIconButton() {
        accountIconButton.click();
    }

    public void clickMyAccountButton() {
        myAccountButton.click();
    }

}
