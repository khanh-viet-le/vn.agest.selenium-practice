package Railway;

import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @Test(description = "User is redirected to Home page after logging out")
    public void TC06() {
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with valid Email and Password", () -> {});
        step("3. Click on \"FAQ\" tab", () -> {});
        step("4. Click on \"Log out\" tab", () -> {
            vp("Home page displays. \"Log out\" tab is disappeared.", () -> {});
        });
    }
}
