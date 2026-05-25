package Railway;

import org.openqa.selenium.By;

import Common.Utilities;

public class LoginPage extends GeneralPage {
    // #region Locators
    private final By _email = By.xpath("//form[@class='LoginForm']//input[@id='username']");
    private final By _password = By.xpath("//form[@class='LoginForm']//input[@id='password']");
    private final By _loginButton = By.xpath("//form[@class='LoginForm']//input[@title='Login']");

    private final By _errorMsg = By.cssSelector("#content .message");

    private final By _passResetEmail = By.xpath("//form//input[@id='email']");
    private final By _passResetButton = By.xpath("//form//input[@type='submit']");

    private final By _newPass = By.xpath("//form//input[@id='newPassword']");
    private final By _confirmPass = By.xpath("//form//input[@id='confirmPassword']");
    private final By _changePassButton = By.xpath("//form//input[@type='submit']");
    private final By _confirmPassErrorMsg = By.cssSelector(".confirm-password .validation-error");

    private final By _formTitle = By.xpath("//form//legend");
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

    @SuppressWarnings("null")
    public void clickLinkByText(String text) {
        Utilities.click(Utilities.findElement(By.linkText(text)));
    }

    public void submitPassReset(Account account) {
        Utilities.enter(_passResetEmail, account.getEmail());
        Utilities.click(_passResetButton);
    }

    public void submitPassChange(Account account) {
        submitPassChange(account, account.getPassword());
    }

    public void submitPassChange(Account account, String confirmPass) {
        Utilities.enter(_newPass, account.getPassword());
        Utilities.enter(_confirmPass, confirmPass);
        Utilities.click(_changePassButton);
    }

    public String getFormTitle() {
        return Utilities.getText(_formTitle);
    }

    public String getConfirmErrorMsg() {
        return Utilities.getText(_confirmPassErrorMsg);
    }
    // #endregion
}
