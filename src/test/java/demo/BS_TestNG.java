package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class BS_TestNG {

    ChromeDriver driver;
    String[] menus = {"Support", "Status"};
    String[] titles = {"FAQs on Live Product | Support | BrowserStack", "BrowserStack Status"};

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public void TearDown() {
        driver.quit();

    }

    @Test
    public void testBSPage() {
        String developerLocator = "//*[@id='developers-menu-toggle']/span";

        for (int i = 0; i < menus.length; i++) {
            driver.get("https://www.browserstack.com");
            WebElement developerDropdown = driver.findElement(By.xpath(developerLocator));
            developerDropdown.click();

            WebElement element = driver.findElement(By.xpath("//*[text()='" + menus[i] + "']"));
            element.click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String title = driver.getTitle();
            System.out.println(driver.getTitle());
            Assert.assertEquals(driver.getTitle(), titles[i]);
        }
    }
}