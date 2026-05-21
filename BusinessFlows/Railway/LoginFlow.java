package Railway;

import Constants.MenuItem;

public class LoginFlow {
    // #region Used Page Objects
    LoginPage loginPage;
    HomePage homePage;

    // #endregion
    public HomePage login(Account account) {
        homePage = HomePage.open();
        loginPage = homePage.goToPage(MenuItem.LOGIN);
        homePage = loginPage.submitLogin(account);

        return homePage;
    }
}
