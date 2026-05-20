package Railway;

import Constants.MenuItem;
import Guerrillamai.MailPage;

public class RegisterFlow {
    // #region Used Page Objects
    MailPage mailPage = new MailPage();
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();
    // #endregion

    // #region Constants
    private static final String COMPLETE_TITLE = "Thank you for registering your account";

    // #endregion

    // #region Methods
    /**
     * Register (but not yet activate) an account
     * 
     * @param email
     * @param password
     */
    public boolean register(Account account) {
        homePage = homePage.open();
        registerPage = homePage.goToPage(MenuItem.REGISTER);
        registerPage = registerPage.submitRegister(account);

        return registerPage.getTitle().contains(COMPLETE_TITLE);
    }

    public void activate(Account account) {

    }
    // #endregion
}
