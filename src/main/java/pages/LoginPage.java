package pages;

import locators.LoginLocators;
import objects.Account;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Basepage {


    private String get;
    private String getText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Login method with account
     *
     * @param account
     */
    public void login(Account account) {
        sendKeys(LoginLocators.input_username, account.getUsername());
        sendKeys(LoginLocators.input_password, account.getPassword());
        click(LoginLocators.button_login);
    }

    /**
     * Login method with account
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        sendKeys(LoginLocators.input_username, username);
        sendKeys(LoginLocators.input_password, password);
        click(LoginLocators.button_login);
    }

    /**
     * Get Login Message
     */
    public String getLoginMessage() {
        return getText(LoginLocators.element_message);
    }
}
