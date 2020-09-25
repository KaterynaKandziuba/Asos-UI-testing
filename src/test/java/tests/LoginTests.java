package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private String EXPECTED_USERNAME_ERROR_MESSAGE = "Oops! You need to type your email here";
    private String EXPECTED_PASSWORD_ERROR_MESSAGE = "Hey, we need a password here";

    @Test(priority = 10)
    public void checkLoginWithEmptyFields() {
        getHomePage().clickAccountIconButton();
        getBasePage().implicitWait(10);
        getHomePage().clickMyAccountButton();
        getBasePage().waitForLoadPageComplete(30);
        getLoginPage().clickSigninButton();
        getBasePage().waitForLoadPageComplete(30);
        Assert.assertTrue(getLoginPage().getEmailErrorMessage().contains(EXPECTED_USERNAME_ERROR_MESSAGE));
        Assert.assertTrue(getLoginPage().getPasswordErrorMessage().contains(EXPECTED_PASSWORD_ERROR_MESSAGE));

    }
}
