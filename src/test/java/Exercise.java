import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/support");
        String title = driver.getTitle();
        System.out.println(title);

        WebElement developer1 = driver.findElement(By.className("nav_item_name"));
        developer1.click();
        WebElement document = driver.findElement(By.xpath("//a[contains(text(),'Documentation')]"));
        document.click();

        WebElement developer2 = driver.findElement(By.xpath("//*[@class='nav_item_name']"));
        developer2.click();
        WebElement support = driver.findElement(By.xpath("//a[contains(text(),'Support')]"));
        support.click();

        WebElement developer3 = driver.findElement(By.xpath("//*[@class='nav_item_name']"));
        developer3.click();
        WebElement status = driver.findElement(By.xpath("//a[contains(text(),'Status')]"));
        status.click();

        driver.navigate().back();

        WebElement dev4 = driver.findElement(By.xpath("//*[@class='nav_item_name']"));
        dev4.click();
        WebElement release = driver.findElement(By.xpath("//a[contains(text(),'Release Notes')]"));
        release.click();

        driver.navigate().back();

        WebElement dev5 = driver.findElement(By.xpath("//*[@class='nav_item_name']"));
        dev5.click();
        WebElement open = driver.findElement(By.xpath("//a[contains(text(),'Open Source')]"));
        open.click();

        driver.close();

        driver.quit();
    }
}