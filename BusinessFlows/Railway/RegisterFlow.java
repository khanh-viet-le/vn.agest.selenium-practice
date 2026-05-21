package Railway;

import Common.Utilities;
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
    private static final String COMFIRM_TITLE = "Please confirm your account";
    private static final String COMPLETE_MSG = "Registration Confirmed! You can now log in to the site";
    // #endregion

    // #region Methods
    /**
     * Register (but not yet activate) an account
     * 
     * @param email
     * @param password
     */
    public boolean register(Account account) {
        Utilities.switchToNewTab();
        homePage = HomePage.open();
        registerPage = homePage.goToPage(MenuItem.REGISTER);
        registerPage = registerPage.submitRegister(account);
        boolean didRegister = registerPage.getTitle().contains(COMPLETE_TITLE);

        Utilities.closeTab();
        Utilities.switchToLastTab();

        return didRegister;
    }

    public boolean activate(Account account) {
        Utilities.switchToNewTab();
        mailPage = MailPage.open();
        mailPage.login(account.getEmail());
        mailPage.selectMailInbox(COMFIRM_TITLE);
        mailPage.clickLinkInMail();

        homePage = HomePage.open();
        registerPage = homePage.goToPage(MenuItem.REGISTER);
        boolean didActivate = registerPage.getCompleteMsg().contains(COMPLETE_MSG);
        Utilities.switchToLastTab();

        return didActivate;
    }
    // #endregion
}
