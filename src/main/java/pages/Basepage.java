package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Basepage {
    WebDriver driver;

    public Basepage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setupDriver(String browser) {
        System.out.println(browser);
        if (browser.equalsIgnoreCase("Firefox")) {
      //      System.setProperty("webdriver.gecko.driver", "/Users/doquyen2404/Desktop/Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else {
      //      System.setProperty("webdriver.chrome.driver", "/Users/doquyen2404/Desktop/Drivers/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * Maximize browser
     */
    public void maximize() {
        Reporter.log("Maximize browser");
        driver.manage().window().maximize();
    }

    /**
     * Find element
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        Reporter.log("Find element by locator " + by.toString());
        return driver.findElement(by);
    }

    /**
     * Find element and wait
     * @param by
     * @param seconds
     * @return
     */
    public WebElement waitElementClickable(By by, int seconds) {
        Reporter.log("Find element by locator " + by.toString() + "during " + seconds + " seconds");
        return new WebDriverWait(driver, seconds)
            .until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Fullscreen method
     */
    public void fullscreen() {
        Reporter.log("Fullscreen");
        driver.manage().window().fullscreen();
    }

    /**
     * Refresh browser
     */
    public void refresh() {
        Reporter.log("Refresh");
        driver.navigate().refresh();
    }

    /**
     * Back browser
     */
    public void back() {
        Reporter.log("Back");
        driver.navigate().back();
    }

    /**
     * Forward browser
     */
    public void forward() {
        Reporter.log("Forward");
        driver.navigate().forward();
    }

    /**
     * Navigate to url
     *
     * @param url
     */
    public void get(String url) {
        Reporter.log("Navigate to " + url);
        driver.get(url);
    }

    /**
     * get Title
     *
     * @return
     */
    public String getTitle() {
        Reporter.log("Get current title");
        return driver.getTitle();
    }

    /**
     * Get URL
     *
     * @return
     */
    public String getCurrentUrl() {
        Reporter.log("Get current URL");
        return driver.getCurrentUrl();
    }

    /**
     * Get Text
     */
    public String getText(By by) {
        Reporter.log("Get text on the element by locator " + by.toString());
        /*return driver.findElement(by).getText();*/ //khi khong goi ham findElement phia tren
        return findElement(by).getText();
    }

    /**
     * sendKeys
     *
     * @param by
     * @param value
     */
    public void sendKeys(By by, String value) {
        Reporter.log("Get text on the element by locator " + by.toString() + "with the value: " + value);
        /*WebElement element = driver.findElement(by);
        element.sendKeys(value);*/ //khi khong goi ham findElement phia tren
        findElement(by).sendKeys(value);

    }

    /**
     * Click on element
     *
     * @param by
     */
    public void click(By by) {
        Reporter.log("Click on the element by locator " + by.toString());
        /*WebElement element = driver.findElement(by);
        element.click();*/ //khi khong goi ham findElement phia tren
        findElement(by).click();
    }

    /**
     * Clear text on element
     *
     * @param by
     */
    public void clear(By by) {
        Reporter.log("Clear text on the element by locator " + by.toString());
        /*WebElement element = driver.findElement(by);
        element.clear();*/ //khi khong goi ham findElement phia tren
        findElement(by).clear();
    }

    /**
     * Check element isEnabled or not
     * @param by
     * @return
     */
    public boolean isEnabled(By by) {
        Reporter.log("Get enabled property on the element by locator " + by.toString());
        /*return driver.findElement(by).isEnabled();*/ //khi khong goi ham findElement phia tren
        return findElement(by).isEnabled();
    }

    /**
     * Check element isSelected or not
     * @param by
     * @return
     */
    public boolean isSelected(By by) {
        Reporter.log("Get selected property on the element by locator " + by.toString());
        /*return driver.findElement(by).isSelected();*/
        return findElement(by).isSelected();
    }

    /**
     * Check element isDisplayed or not
     * @param by
     * @return
     */
    public boolean isDisplayed(By by) {
        Reporter.log("Get displayed property on the element by locator " + by.toString());
        /*return driver.findElement(by).isDisplayed();*/
        return findElement(by).isDisplayed();
    }

    /**
     * get TagName of an element
     * @param by
     * @return
     */
    public String getTagName(By by) {
        Reporter.log("Get TagName on the element by locator " + by.toString());
        /*return driver.findElement(by).getTagName();*/
        return findElement(by).getTagName();
    }

    /*Rectangle res =  driver.findElement(By.cssSelector("h1")).getRect();*/
    /**
     * Get Rectangle
     * @param by
     * @return
     */
    public Rectangle getRect(By by) {
        Reporter.log("Get Rectangle on the element by locator " + by.toString());
        /*return driver.findElement(by).getRect();*/
        return findElement(by).getRect();
    }

    /*String cssValue = driver.findElement(By.linkText("More information...")).getCssValue("color");*/
    /**
     * Get CssValue
     * @param by
     * @return
     */
    public String getCssValue(By by, String value) {
        Reporter.log("Get CssValue on the element by locator " + by.toString());
        /*return driver.findElement(by).getCssValue(value);*/
        return findElement(by).getCssValue(value);
    }
}
