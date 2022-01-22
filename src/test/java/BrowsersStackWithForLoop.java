import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowsersStackWithForLoop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] menus = {"Support", "Status", "Release Notes", "Open Source", "Events", "Test University"};

        for (int i = 0; i < menus.length; i++) {
            driver.get("https://www.browserstack.com");
            WebElement developerDropdown = driver.findElement(By.xpath("//*[@id='developers-menu-toggle']/span"));
            developerDropdown.click();

            WebElement element = driver.findElement(By.xpath("//*[text()='" + menus[i] + "']"));
            element.click();

            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
}