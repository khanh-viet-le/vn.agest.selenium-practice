package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.Utilities;
import Constants.MenuItem;
import Guerrillamai.MailPage;

public class CreateAccountTest extends TestBase {
    // #region Constants
    private Account account;
    // #endregion

    // #region Used Page Objects
    HomePage homePage;
    RegisterPage registerPage;
    MailPage mailPage;
    // #endregion

    @Test(description = "User can't create account with an already in-use email")
    public void TC07() {
        step("Pre-condition: an actived account is existing", () -> {
            account = Account.getValid();
        });

        step("1. Navigate to QA Railway Website", () -> {
            homePage = HomePage.open();
        });

        step("2. Click on \"Register\" tab", () -> {
            registerPage = homePage.goToPage(MenuItem.REGISTER);
        });

        step("3. Enter information of the created account in Pre-condition");
        step("4. Click on \"Register\" button", () -> {
            registerPage.submitRegister(account);

            vp("Error message \"This email address is already in use.\" displays above the form.", () -> {
                Assert.assertEquals(registerPage.getErrorMsg(), "This email address is already in use.",
                        "Error message is not displayed as expected.");
            });
        });
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC08() {
        step("1. Navigate to QA Railway Website", () -> {
            homePage = HomePage.open();
        });

        step("2. Click on \"Register\" tab", () -> {
            registerPage = homePage.goToPage(MenuItem.REGISTER);
        });

        step("3. Enter valid email address and leave other fields empty");
        step("4. Click on \"Register\" button", () -> {
            account = Account.getRandom();
            account.setPassword("");
            account.setPid("");
            registerPage.submitRegister(account);

            vp("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.",
                    () -> {
                        Assert.assertEquals(registerPage.getErrorMsg(),
                                "There're errors in the form. Please correct the errors and try again.",
                                "Error message is not displayed as expected.");
                    });

            vp("Next to password fields, error message \"Invalid password length\" displays", () -> {
                Assert.assertEquals(registerPage.getPassError(), "Invalid password length",
                        "Error message is not displayed as expected.");
            });

            vp("Next to PID field, error message \"Invalid ID length\" displays", () -> {
                Assert.assertEquals(registerPage.getPidError(), "Invalid ID length",
                        "Error message is not displayed as expected.");
            });
        });
    }

    @Test(description = "User create and activate account")
    public void TC09() {
        step("1. Navigate to QA Railway Website", () -> {
            homePage = HomePage.open();

            vp("Home page is shown with guide containing href \"create an account\" to \"Register\" page", () -> {
                Assert.assertTrue(homePage.checkLinkDisplayedByText("create an account"),
                        "\"create an account\" link is not displayed as expected.");
            });
        });

        step("2. Click on \"create an account\"", () -> {
            registerPage = homePage.clickLinkByText("create an account");

            vp("Register page is shown", () -> {
                Assert.assertEquals(registerPage.getTitle(), "Create account",
                        "Register page is not displayed as expected.");
            });
        });

        step("3. Enter valid information into all fields");
        step("4. Click on \"Register\" button", () -> {
            account = Account.getRandom();
            registerPage.submitRegister(account);

            vp("\"Thank you for registering your account\" is shown", () -> {
                Assert.assertEquals(registerPage.getTitle(), "Thank you for registering your account",
                        "Title is not displayed as expected.");
            });
        });

        step("5. Get email information (webmail address, mailbox and password) and navigate to that webmail", () -> {
            Utilities.switchToNewTab();
            mailPage = MailPage.open();
        });

        step("6. Login to the mailbox", () -> {
            mailPage.login(account.getEmail());
        });

        step("7. Open email with subject containing \"Please confirm your account\"  and the email of the new account at step 3",
                () -> {
                    mailPage.selectMailInbox("Please confirm your account");
                });

        step("8. Click on the activate link", () -> {
            mailPage.clickLinkInMail();
            Utilities.switchToLastTab();

            vp("Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site\" is shown",
                    () -> {
                        Assert.assertEquals(registerPage.getCompleteMsg(),
                                "Registration Confirmed! You can now log in to the site.",
                                "Complete message is not displayed as expected.");
                    });
        });
    }
}
