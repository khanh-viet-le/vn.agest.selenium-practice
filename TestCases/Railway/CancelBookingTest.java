package Railway;

import org.testng.annotations.Test;

public class CancelBookingTest extends TestBase {
    @Test(description = "User can cancel a ticket")
    public void TC16() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with a valid account", () -> {});
        step("3. Book a ticket", () -> {});
        step("4. Click on \"My ticket\" tab", () -> {});
        step("5. Click on \"Cancel\" button of ticket which user want to cancel.", () -> {});
        step("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"", () -> {
            vp("The canceled ticket is disappeared.", () -> {});
        });
    }
}
