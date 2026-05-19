package Railway;

import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    @Test(description = "User can't create account with an already in-use email")
    public void TC07() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Register\" tab", () -> {});
        step("3. Enter information of the created account in Pre-condition", () -> {});
        step("4. Click on \"Register\" button", () -> {
            vp("Error message \"This email address is already in use.\" displays above the form.", () -> {});
        });
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC08() {
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Click on \"Register\" tab", () -> {});
        step("3. Enter valid email address and leave other fields empty", () -> {});
        step("4. Click on \"Register\" button", () -> {
            vp("Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form." + 
                                "Next to password fields, error message \"Invalid password length.\" displays" + 
                                "Next to PID field, error message \"Invalid ID length.\" displays", () -> {});
        });
    }

    @Test(description = "User create and activate account")
    public void TC09() {
        step("1. Navigate to QA Railway Website", () -> {
            vp("Home page is shown with guide containing href \"create an account\" to \"Register\" page", () -> {});
        });
        step("2. Click on \"Create an account\"", () -> {
            vp("Register page is shown", () -> {});
        });
        step("3. Enter valid information into all fields", () -> {});
        step("4. Click on \"Register\" button", () -> {
            vp("\"Thank you for registering your account\" is shown", () -> {});
        });
        step("5. Get email information (webmail address, mailbox and password) and navigate to that webmail", () -> {});
        step("6. Login to the mailbox", () -> {});
        step("7. Open email with subject containing \"Please confirm your account\"  and the email of the new account at step 3", () -> {});
        step("8. Click on the activate link", () -> {
            vp("Redirect to Railways page and message \"Registration Confirmed! You can now log in to the site\" is shown", () -> {});
        });
    }
}
