package Railway;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        step("1. Navigate to QA Railway Website", () -> {});	
        step("2. Click on \"Login\" tab", () -> {});	
        step("3. Enter valid Email and Password", () -> {});	
        step("4. Click on \"Login\" button", () -> {
            vp("User is logged into Railway. Welcome user message is displayed.", () -> {});
        });
    }

    @Test(description = "User cannot login with blank \"Username\" textbox")
    public void TC02() {
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Login\" tab", () -> {});
        step("3. User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox", () -> {
            vp("User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.", () -> {});
        }); 
    }

    @Test(description = "User cannot log into Railway with invalid password ")
    public void TC03() {
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Login\" tab", () -> {});
        step("3. Enter valid Email and invalid Password", () -> {});
        step("4. Click on \"Login\" button", () -> {
            vp("Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed", () -> {});
        }); 
    }

    @Test(description = "System shows message when user enters wrong password many times")
    public void TC04() {
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Login\" tab", () -> {});
        step("3. Enter valid information into \"Username\" textbox except \"Password\" textbox", () -> {});
        step("4. Click on \"Login\" button", () -> {
            vp("\"Invalid username or password. Please try again\" is shown", () -> {});
        });
        step("5. Repeat step 3 and 4 three more times", () -> {
            vp("User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.", () -> {});
        });
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC05() {
        step("Pre-condition: a not-active account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Login\" tab", () -> {});
        step("3. Enter username and password of account hasn't been activated", () -> {});
        step("4. Click on \"Login\" button", () -> {
            vp("User can't login and message \"Invalid username or password. Please try again.\" appears.", () -> {});
        });
    }
}
