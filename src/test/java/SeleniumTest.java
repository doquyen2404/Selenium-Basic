import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
        //Khoi tao Chrome Driver gan vao WebDriver
        WebDriver driver = new ChromeDriver();

        //Mo browser len thay vi copy link va paste
        driver.get("https://google.com");

        driver.getTitle(); // => "Google"

        //Tim element voi ten la "q" set vao bien co ten la searchBox, kieu du lieu la WebElement
        //Co 7 cach tim: name, id, tagname, xpath, partiallinktext, linktext, cssSelector, className
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        //Nhung the trong input goi la html tag
        //mau xanh: key, mau cam: value
        //Nhap text vao
        searchBox.sendKeys("Selenium");
//       searchButton.click();
//
        //Tim element roi gan gia tri
//       driver.findElement(By.name("q")).getAttribute("value"); // => "Selenium"

        driver.quit();
    }

}
