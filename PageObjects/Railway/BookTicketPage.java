package Railway;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Date;
import Common.Utilities;
import Constants.AppConstant;
import Constants.SeatType;
import Constants.Station;

public class BookTicketPage extends GeneralPage {
    // #region Locators
    private final By _departDate = By.xpath("//form//select[@name='Date']");
    private final By _departFrom = By.xpath("//form//select[@name='DepartStation']");
    private final By _arriveAt = By.xpath("//form//select[@name='ArriveStation']");
    private final By _seatType = By.xpath("//form//select[@name='SeatType']");
    private final By _ticketAmount = By.xpath("//form//select[@name='TicketAmount']");
    private final By _submitBooking = By.xpath("//form//input[@type='submit']");

    private final By _title = By.cssSelector("#content h1");
    private final By _ticketRow = By.cssSelector(".MyTable tr.OddRow");
    // #endregion

    // #region Methods
    public void submitBookTiket(Ticket ticket) {
        Utilities.selectByVisibleText(_departDate, Date.formatDate(ticket.getDepartDate(), AppConstant.DATE_FORMAT));
        Utilities.selectByVisibleText(_departFrom, ticket.getDepartFrom().getName());
        Utilities.selectByVisibleText(_arriveAt, ticket.getArriveAt().getName());
        Utilities.selectByVisibleText(_seatType, ticket.getSeatType().getName());
        Utilities.selectByVisibleText(_ticketAmount, ticket.getTicketAmount() + "");
        Utilities.click(_submitBooking);
    }

    public String getTitle() {
        return Utilities.getText(_title);
    }

    public List<Ticket> getBookedTicketList() {
        List<Ticket> tickets = new ArrayList<>();

        List<WebElement> rows = Utilities.findElements(_ticketRow);

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            Ticket ticket = new Ticket();

            ticket.setDepartFrom(Station.getByName(cells.get(0).getText().trim()));
            ticket.setArriveAt(Station.getByName(cells.get(1).getText().trim()));
            ticket.setSeatType(SeatType.getByName(cells.get(2).getText().trim()));
            ticket.setDepartDate(Date.getDateFromString(cells.get(3).getText().trim(), AppConstant.DATE_FORMAT));
            ticket.setBookDate(Date.getDateFromString(cells.get(4).getText().trim(), AppConstant.DATE_FORMAT));
            ticket.setTicketAmount(Integer.parseInt(cells.get(6).getText().trim()));
            tickets.add(ticket);
        }

        return tickets;
    }
    // #endregion
}
