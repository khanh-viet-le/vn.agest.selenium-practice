package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.MenuItem;

public class LogoutTest extends TestBase {
    @Test(description = "User is redirected to Home page after logging out")
    public void TC06() {
        step("1. Navigate to QA Railway Website", () -> {
            homePage = homePage.open();
        });

        step("2. Login with valid Email and Password", () -> {
            loginPage = homePage.goToPage(MenuItem.LOGIN);
            homePage = loginPage.submitLogin(Account.getValid());
        });

        step("3. Click on \"FAQ\" tab", () -> {
            faqPage = homePage.goToPage(MenuItem.FAQ);
        });

        step("4. Click on \"Log out\" tab", () -> {
            homePage = faqPage.goToPage(MenuItem.LOGOUT);

            vp("Home page displays.", () -> {
                Assert.assertEquals(homePage.getTitle(), "Welcome to Safe Railway",
                        "Home page is not displayed as expected.");
            });

            vp("\"Log out\" tab is disappeared.", () -> {
                Assert.assertThrows(() -> homePage.checkTabDisplayed(MenuItem.LOGOUT));
            });
        });
    }
}
