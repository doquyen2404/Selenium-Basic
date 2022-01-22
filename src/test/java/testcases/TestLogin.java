package testcases;

import data.Data;
import objects.Account;
import org.junit.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.Constants;

public class TestLogin extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void Setup(@Optional("Firefox") String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/doquyen2404/Desktop/Drivers/geckodriver");
        super.Setup(browserName);
        System.out.println("browserName" + browserName);
        loginPage = new LoginPage(driver);
       // System.out.println(Data.defaultAccount());
    }

    @AfterClass
    public void Teardown() {
        super.Teardown();
    }


    @Test(groups = {"ui, smoketest, regressiontest"}, priority = 1,
            description = "This is a login test case")
    public void verifyLogin() {
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
        String msg = loginPage.getLoginMessage();
        Assert.assertTrue(msg.contains(Constants.LOGIN_SUCCESS_MSG));
    }

    @Test(groups = {"ui, regressiontest"}, priority = 2,
            description = "This is a login test case 02")
    public void verifyLogin2() {
        loginPage.get(Constants.URL);
        loginPage.login(Data.defaultAccount());
        String msg = loginPage.getLoginMessage();
        Assert.assertTrue(msg.contains(Constants.LOGIN_SUCCESS_MSG));
    }
}
