package Railway;

import org.testng.annotations.Test;

import Constants.MenuItem;

public class CancelBookingTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    Account account;
    RegisterFlow registerFlow = new RegisterFlow();
    BookTicketPage bookTicketPage;
    Ticket ticket = new Ticket();

    @Test(description = "User can cancel a ticket")
    public void TC16() {
        step("Pre-condition: an actived account is existing", () -> {
            account = Account.getRandom();
            registerFlow.register(account);
            registerFlow.activate(account);
        });

        step("1. Navigate to QA Railway Website", () -> {
            homePage = HomePage.open();
        });

        step("2. Login with a valid account", () -> {
            loginPage = homePage.goToPage(MenuItem.LOGIN);
            loginPage.submitLogin(account);
        });

        step("3. Book a ticket", () -> {
            bookTicketPage = homePage.goToPage(MenuItem.BOOK_TICKET);
            bookTicketPage.submitBookTiket(ticket);
        });

        step("4. Click on \"My ticket\" tab", () -> {
        });

        step("5. Click on \"Cancel\" button of ticket which user want to cancel.", () -> {
        });

        step("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"", () -> {
            vp("The canceled ticket is disappeared.", () -> {
            });
        });
    }
}
