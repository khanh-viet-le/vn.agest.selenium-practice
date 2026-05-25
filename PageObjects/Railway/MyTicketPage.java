package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Date;
import Common.Utilities;
import Constants.AppConstant;

public class MyTicketPage extends GeneralPage {
    // #region Locators
    private final String _ticketRow = "//*[contains(@class,'MyTable')]"
            + "//td[text()='%s']"
            + "/following-sibling::td[text()='%s']"
            + "/following-sibling::td[text()='%s']"
            + "/following-sibling::td[text()='%s']"
            + "/following-sibling::td[text()='%s']";

    private final String _actionButton = _ticketRow + "/following-sibling::td/input";
    // #endregion

    // #region Methods
    public void cancelTicket(Ticket ticket) {
        Utilities.click(getRowLocator(ticket, _actionButton));
        Utilities.acceptAlertConfirmation();
        Utilities.waitUntilStale(Utilities.findElement(getRowLocator(ticket, _ticketRow)));
    }

    public boolean checkTicketDisplayed(Ticket ticket) {
        try {
            WebElement element = Utilities.findElement(getRowLocator(ticket, _ticketRow));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private By getRowLocator(Ticket ticket, String rawLocator) {
        return Utilities.getLocatorElement(rawLocator,
                ticket.getDepartFrom().getName(),
                ticket.getArriveAt().getName(),
                ticket.getSeatType().getName(),
                Date.formatDate(ticket.getDepartDate(), AppConstant.DATE_FORMAT),
                ticket.getTicketAmount() + "");
    }
    // #endregion
}
