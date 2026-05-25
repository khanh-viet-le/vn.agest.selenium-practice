package Railway;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constants.MenuItem;

public class CancelBookingTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    Account account;
    RegisterFlow registerFlow = new RegisterFlow();
    BookTicketPage bookTicketPage;
    Ticket ticket = new Ticket();
    LoginFlow loginFlow = new LoginFlow();
    MyTicketPage myTicketPage;

    /**
     * @note Ticket is still displayed. expected [false] but found [true]
     */
    @Test
    public void TC16() {
        test("TC16 - User can cancel a ticket");

        step("Pre-condition: an actived account is existing", () -> {
            account = Account.getRandom();
            registerFlow.register(account);
            registerFlow.activate(account);
        });

        step("1. Navigate to QA Railway Website");
        step("2. Login with a valid account", () -> {
            homePage = loginFlow.login(account);
        });

        step("3. Book a ticket", () -> {
            bookTicketPage = homePage.goToPage(MenuItem.BOOK_TICKET);
            bookTicketPage.submitBookTiket(ticket);
        });

        step("4. Click on \"My ticket\" tab", () -> {
            myTicketPage = homePage.goToPage(MenuItem.MY_TICKET);
        });

        step("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        step("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"", () -> {
            myTicketPage.cancelTicket(ticket);

            vp("The canceled ticket is disappeared.", () -> {
                Assert.assertFalse(myTicketPage.checkTicketDisplayed(ticket), "Ticket is still displayed.");
            });
        });
    }
}
