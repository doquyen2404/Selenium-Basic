package locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static By input_username = By.name("username");
    public static By input_password = By.name("password");
    public static By button_login = By.xpath("//*[@id='login']/button");
    public static By element_message = By.id("flash");


}
