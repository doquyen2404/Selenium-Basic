package testcases;

import data.Data;
import objects.Account;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Constants;

import java.util.ArrayList;

public class TestLoginLoop extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void Setup(@Optional("Firefox") String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/doquyen2404/Desktop/Drivers/geckodriver");
        super.Setup(browserName);
        System.out.println("browserName" + browserName);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void Teardown() {
        super.Teardown();
    }


    @Test
    public void verifyLogin() {
        String delimiter = ";";
        ArrayList<Account> list_accounts = Data.getCSVAccount(Constants.ACCOUNT_CSV_FILE, delimiter);
        for (Object object : list_accounts) {
            loginPage.get(Constants.URL);
            loginPage.login((Account) object);
        }
    }
}
