package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//span[@id = 'EmailAddress-error']")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//span[@id = 'Password-error']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//input[@id = 'signin']")
    private WebElement signinButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public void clickSigninButton() {
        signinButton.click();
    }
}
