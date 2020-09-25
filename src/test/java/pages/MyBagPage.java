package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyBagPage extends BasePage {

    @FindBy(xpath = "//span[@class = 'bag-item-quantity-holder bag-item-select2-holder']//span[@class = 'select2-selection select2-selection--single']/span[@title]")
    private WebElement quantityOfGoods;

    @FindBy(xpath = "//ul[@class = 'select2-results__options']/li[text() = '2']")
    private WebElement doubleQuantityOfGoodsOption;

    @FindBy(xpath = "//button[@class = 'bag-item-edit-update']")
    private WebElement itemUpdateButton;

    @FindBy(xpath = "//span[contains(text(), 'Standard Delivery')]")
    private WebElement deliveryButton;

    @FindBy(xpath = "//li[@aria-selected = 'false']")
    private WebElement expressDeliveryButton;

    @FindBy(xpath = "//a[@class = 'bag-total-button bag-total-button--checkout bag-total-button--checkout--total']")
    private WebElement totalCheckoutButton;

    public MyBagPage(WebDriver driver) {
        super(driver);
    }

    public void clickIncreaseQuantityOfGoods() {
        quantityOfGoods.click();
    }

    public void clickDoubleQuantityOfGoodsOption() {
        doubleQuantityOfGoodsOption.click();
    }

    public void clickItemUpdateButton() {
        itemUpdateButton.click();
    }

    public WebElement getItemUpdateButton() {
        return itemUpdateButton;
    }

    public String getQuantityOfGoodsInBag() {
        return quantityOfGoods.getText();
    }

    public void clickDeliveryButton() {
        deliveryButton.click();
    }

    public void clickExpressDeliveryButton() {
        expressDeliveryButton.click();
    }

    public void clickTotalCheckoutButton() {
        totalCheckoutButton.click();
    }
}
