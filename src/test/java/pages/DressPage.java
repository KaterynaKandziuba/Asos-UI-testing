package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressPage extends BasePage {

    @FindBy(xpath = "//a[@class = 'add-button']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div/span[@id = 'selectSizeError']")
    private WebElement selectSizeError;

    @FindBy(xpath = "//select[@data-id = 'sizeSelect']")
    private WebElement selectSizeButton;

    @FindBy(xpath = "//option[text() = 'EU 32']")
    private WebElement selectSizeOption;

    public DressPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public WebElement getSelectSizeErrorAppearance() {
        return selectSizeError;
    }

    public String getSelectSizeErrorAppearanceText() {
        return selectSizeError.getText();
    }

    public void clickSelectSizeButton() {
        selectSizeButton.click();
    }

    public void clickSelectSizeOption() {
        selectSizeOption.click();
    }

    public WebElement getSelectSizeOption() {
        return selectSizeOption;
    }

}
