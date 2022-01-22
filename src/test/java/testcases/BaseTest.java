package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Basepage;
import utils.Constants;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    Basepage basePage;


    @BeforeSuite
    public void Setup(String browserName) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/Users/doquyen2404/Desktop/Drivers/geckodriver");
        basePage = new Basepage(driver);
        driver = basePage.setupDriver(browserName);
        System.out.println(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void Teardown() {
        driver.quit();

    }

}
