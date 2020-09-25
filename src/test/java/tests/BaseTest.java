package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.*;

public class BaseTest {

    private WebDriver driver;
    private static final String ASOS_URL = "https://www.asos.com/";

    //tests don`t executed without full path of chromedriver.exe
    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\1\\IdeaProjects\\AsosTests_Kandziuba_final_project\\src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ASOS_URL);
        getBasePage().waitForLoadPageComplete(30);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public DressPage getDressPage() {
        return new DressPage(driver);
    }

    public MyBagPage getMyBagPage() {
        return new MyBagPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

}
