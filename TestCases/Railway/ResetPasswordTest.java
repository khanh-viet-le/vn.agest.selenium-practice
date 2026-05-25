package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Random;
import Common.Utilities;
import Constants.MenuItem;
import Guerrillamai.MailPage;

public class ResetPasswordTest extends TestBase {
    // #region Constants
    Account account;
    RegisterFlow registerFlow = new RegisterFlow();
    HomePage homePage;
    LoginPage loginPage;
    MailPage mailPage;
    // #endregion

    /**
     * @note Error message is not displayed as expected. expected [The new password
     *       cannot be the same with the current password] but found [Password
     *       changed! Click here to login.]
     */
    @Test
    public void TC10() {
        test("TC10 - Reset password shows error if the new password is same as current");

        step("Pre-condition: an actived account is existing", () -> {
            account = Account.getRandom();
            registerFlow.register(account);
            registerFlow.activate(account);
        });

        step("1. Navigate to QA Railway Login page", () -> {
            homePage = HomePage.open();
            loginPage = homePage.goToPage(MenuItem.LOGIN);
        });

        step("2. Click on \"Forgot Password page\" link", () -> {
            loginPage.clickLinkByText("Forgot Password page");
        });

        step("3. Enter the email address of the activated account");
        step("4. Click on \"Send Instructions\" button", () -> {
            loginPage.submitPassReset(account);
        });

        step("5. Login to the mailbox (the same mailbox when creating account)", () -> {
            mailPage = MailPage.open();
            mailPage.login(account.getEmail());
        });

        step("6. Open email with subject containing \"Please reset your password\" and the email of the account at step 3",
                () -> {
                    mailPage.selectMailInbox("Please reset your password");
                });

        step("7. Click on reset link", () -> {
            mailPage.clickLinkInMail();
            Utilities.switchToLastTab();

            vp("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token",
                    () -> {
                        Assert.assertEquals(loginPage.getFormTitle(), "Password Change Form",
                                "Form title is not displayed as expected.");
                    });
        });

        step("8. Input same password into 2 fields  \"new password\" and \"confirm password\"");
        step("9. Click Reset Password", () -> {
            loginPage.submitPassChange(account);

            vp("Message \"The new password cannot be the same with the current password\" is shown", () -> {
                Assert.assertEquals(loginPage.getErrorMsg(),
                        "The new password cannot be the same with the current password",
                        "Error message is not displayed as expected.");
            });
        });
    }

    @Test
    public void TC11() {
        test("TC11 - Reset password shows error if the new password and confirm password doesn't match");

        step("Pre-condition: an actived account is existing", () -> {
            account = Account.getRandom();
            registerFlow.register(account);
            registerFlow.activate(account);
        });

        step("1. Navigate to QA Railway Login page", () -> {
            homePage = HomePage.open();
            loginPage = homePage.goToPage(MenuItem.LOGIN);
        });

        step("2. Click on \"Forgot Password page\" link", () -> {
            loginPage.clickLinkByText("Forgot Password page");
        });

        step("3. Enter the email address of the activated account");
        step("4. Click on \"Send Instructions\" button", () -> {
            loginPage.submitPassReset(account);
        });

        step("5. Login to the mailbox (the same mailbox when creating account)", () -> {
            mailPage = MailPage.open();
            mailPage.login(account.getEmail());
        });

        step("6. Open email with subject containing \"Please reset your password\" and the email of the account at step 3",
                () -> {
                    mailPage.selectMailInbox("Please reset your password");
                });

        step("7. Click on reset link", () -> {
            mailPage.clickLinkInMail();
            Utilities.switchToLastTab();

            vp("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token",
                    () -> {
                        Assert.assertEquals(loginPage.getFormTitle(), "Password Change Form",
                                "Form title is not displayed as expected.");
                    });
        });

        step("8. Input different password into 2 fields  \"new password\" and \"confirm password\"");
        step("9. Click Reset Password", () -> {
            loginPage.submitPassChange(account, Random.generateText(8));

            vp("Error message \"Could not reset password. Please correct the errors and try again.\" displays next to the confirm password field.",
                    () -> {
                        Assert.assertEquals(loginPage.getErrorMsg(),
                                "Could not reset password. Please correct the errors and try again.",
                                "Error message is not displayed as expected.");
                    });

            vp("Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.",
                    () -> {
                        Assert.assertEquals(loginPage.getConfirmErrorMsg(),
                                "The password confirmation did not match the new password.",
                                "Error message is not displayed as expected.");
                    });
        });
    }
}
