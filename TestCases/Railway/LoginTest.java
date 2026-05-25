package Railway;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Constants.MenuItem;
import Constants.ValidAccount;

public class LoginTest extends TestBase {

    // #region Constants
    private static final Account validAcc = Account.getValid();
    private static final Account blankEmailAcc = new Account("");
    private static final Account invalidPassAcc = new Account(ValidAccount.EMAIL, "invalidPass");
    private static final Account randomAcc = Account.getRandom();
    // #endregion

    // #region Used Page Objects
    HomePage homePage;
    LoginPage loginPage;
    RegisterFlow registerFlow = new RegisterFlow();
    // #endregion

    @BeforeMethod
    private void setUp(Method method) {
        if (method.getName().equals("TC05")) {
            Assert.assertTrue(registerFlow.register(randomAcc));
        }

        homePage = HomePage.open();
        loginPage = homePage.goToPage(MenuItem.LOGIN);
    }

    @Test
    public void TC01() {
        test("TC01 - User can log into Railway with valid username and password");

        step("1. Navigate to QA Railway Website");
        step("2. Click on \"Login\" tab");

        step("3. Enter valid Email and Password");
        step("4. Click on \"Login\" button", () -> {
            homePage = loginPage.submitLogin(validAcc);

            vp("User is logged into Railway. Welcome user message is displayed.", () -> {
                String expectedMsg = "Welcome " + validAcc.getEmail();
                Assert.assertEquals(homePage.getWelcomeMsg(), expectedMsg,
                        "Welcome message is not displayed as expected.");
            });
        });
    }

    @Test
    public void TC02() {
        test("TC02 - User cannot login with blank \"Username\" textbox");

        step("1. Navigate to QA Railway Website");
        step("2. Click on \"Login\" tab");

        step("3. User doesn't type any words into \"Username\" textbox " +
                "but enter valid information into \"Password\" textbox",
                () -> {
                    loginPage.submitLogin(blankEmailAcc);

                    vp("User can't login " +
                            "and message \"There was a problem with your login and/or errors exist in your form. \" appears.",
                            () -> {
                                Assert.assertEquals(loginPage.getErrorMsg(),
                                        "There was a problem with your login and/or errors exist in your form.",
                                        "Error message is not displayed as expected.");
                            });
                });
    }

    /**
     * @note Error message is not displayed as expected. expected [There was a
     *       problem with your login and/or errors exist in your form.] but found
     *       [Invalid username or password. Please try again.]
     */
    @Test
    public void TC03() {
        test("TC03 - User cannot log into Railway with invalid password");

        step("1. Navigate to QA Railway Website");
        step("2. Click on \"Login\" tab");

        step("3. Enter valid Email and invalid Password");
        step("4. Click on \"Login\" button", () -> {
            loginPage.submitLogin(invalidPassAcc);
            log("Login Account: " + invalidPassAcc);

            vp("Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed",
                    () -> {
                        Assert.assertEquals(loginPage.getErrorMsg(),
                                "There was a problem with your login and/or errors exist in your form.",
                                "Error message is not displayed as expected.");
                    });
        });
    }

    /**
     * @note Error message is not displayed as expected. expected [You have used 4
     *       out of 5 login attempts. After all 5 have been used, you will be unable
     *       to login for 15 minutes.] but found [Invalid username or password.
     *       Please try again.]
     */
    @Test
    public void TC04() {
        test("TC04 - System shows message when user enters wrong password many times");

        step("1. Navigate to QA Railway Website");
        step("2. Click on \"Login\" tab");

        step("3. Enter valid information into \"Username\" textbox except \"Password\" textbox");
        step("4. Click on \"Login\" button", () -> {
            loginPage.submitLogin(invalidPassAcc);

            vp("\"Invalid username or password. Please try again\" is shown", () -> {
                Assert.assertEquals(loginPage.getErrorMsg(),
                        "Invalid username or password. Please try again.",
                        "Error message is not displayed as expected.");
            });
        });

        step("5. Repeat step 3 and 4 three more times", () -> {
            for (int i = 1; i <= 3; i++) {
                loginPage.submitLogin(invalidPassAcc);
            }

            vp("User can't login " +
                    "and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.",
                    () -> {
                        Assert.assertEquals(loginPage.getErrorMsg(),
                                "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.",
                                "Error message is not displayed as expected.");
                    });
        });
    }

    @Test
    public void TC05() {
        test("TC05 - User can't login with an account hasn't been activated");

        step("Pre-condition: a not-active account is existing");
        step("1. Navigate to QA Railway Website");
        step("2. Click on \"Login\" tab");

        step("3. Enter username and password of account hasn't been activated");
        step("4. Click on \"Login\" button", () -> {
            loginPage.submitLogin(randomAcc);

            vp("User can't login and message \"Invalid username or password. Please try again.\" appears.", () -> {
                Assert.assertEquals(loginPage.getErrorMsg(), "Invalid username or password. Please try again.",
                        "Error message is not displayed as expected.");
            });
        });
    }
}
