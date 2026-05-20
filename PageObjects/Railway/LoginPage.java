package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class LoginPage extends GeneralPage {
    // #region Locators
    private final By _email = By.xpath("//form[@class='LoginForm']//input[@id='username']");
    private final By _password = By.xpath("//form[@class='LoginForm']//input[@id='password']");
    private final By _loginButton = By.xpath("//form[@class='LoginForm']//input[@title='Login']");

    private final By _errorMsg = By.cssSelector("#content .message.error.LoginForm");

    // #endregion

    // #region Methods
    public HomePage submitLogin(Account account) {
        if (!account.getEmail().isBlank()) {
            Utilities.enter(_email, account.getEmail());
        }

        if (!account.getPassword().isBlank()) {
            Utilities.enter(_password, account.getPassword());
        }

        Utilities.click(_loginButton);

        return new HomePage();
    }

    public String getErrorMsg() {
        return Utilities.getText(_errorMsg);
    }

    // #endregion
}
