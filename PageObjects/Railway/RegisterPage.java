package Railway;

import org.openqa.selenium.By;
import Common.Utilities;

public class RegisterPage extends GeneralPage {
    // #region Locators
    private final By _email = By.xpath("//form[@id='RegisterForm']//input[@id='email']");
    private final By _password = By.xpath("//form[@id='RegisterForm']//input[@id='password']");
    private final By _confirmPass = By.xpath("//form[@id='RegisterForm']//input[@id='confirmPassword']");
    private final By _pid = By.xpath("//form[@id='RegisterForm']//input[@id='pid']");
    private final By _registerButton = By.xpath("//form[@id='RegisterForm']//input[@title='Register']");

    private final By _title = By.cssSelector("#content h1");
    // #endregion

    // #region Methods
    public RegisterPage submitRegister(Account account) {
        if (!account.getEmail().isBlank()) {
            Utilities.enter(_email, account.getEmail());
        }

        if (!account.getPassword().isBlank()) {
            Utilities.enter(_password, account.getPassword());
            Utilities.enter(_confirmPass, account.getPassword());
        }

        if (!account.getPid().isBlank()) {
            Utilities.enter(_pid, account.getPid());
        }

        Utilities.click(_registerButton);

        return this;
    }

    public String getTitle() {
        return Utilities.getText(_title);
    }
    // #endregion
}
