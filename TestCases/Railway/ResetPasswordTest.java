package Railway;

import org.testng.annotations.Test;

public class ResetPasswordTest extends TestBase {
    @Test(description = "Reset password shows error if the new password is same as current")
    public void TC10() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Login page", () -> {});
        step("2. Click on \"Forgot Password page\" link", () -> {});
        step("3. Enter the email address of the activated account", () -> {});
        step("4. Click on \"Send Instructions\" button", () -> {});
        step("5. Login to the mailbox (the same mailbox when creating account)", () -> {});
        step("6. Open email with subject containing \"Please reset your password\" and the email of the account at step 3", () -> {});
        step("7. Click on reset link", () -> {
            vp("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token", () -> {});
        });
        step("8. Input same password into 2 fields  \"new password\" and \"confirm password\"", () -> {});
        step("9. Click Reset Password", () -> {
            vp("Message \"The new password cannot be the same with the current password\" is shown", () -> {});
        });
    }

    @Test(description = "Reset password shows error if the new password and confirm password doesn't match")
    public void TC11() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Login page", () -> {});
        step("2. Click on \"Forgot Password page\" link", () -> {});
        step("3. Enter the email address of the activated account", () -> {});
        step("4. Click on \"Send Instructions\" button", () -> {});
        step("5. Login to the mailbox (the same mailbox when creating account)", () -> {});
        step("6. Open email with subject containing \"Please reset your password\" and the email of the account at step 3", () -> {});
        step("7. Click on reset link", () -> {
            vp("Redirect to Railways page and Form \"Password Change Form\" is shown with the reset password token", () -> {});
        });
        step("8. Input different password into 2 fields  \"new password\" and \"confirm password\"", () -> {});
        step("9. Click Reset Password", () -> {
            vp("Error message \"The password confirmation did not match the new password.\" displays next to the confirm password field.", () -> {});
        });
    }
}   
