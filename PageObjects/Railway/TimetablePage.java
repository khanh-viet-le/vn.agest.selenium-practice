package Railway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import Common.Utilities;
import Constants.SeatType;
import Constants.Station;

public class TimetablePage extends GeneralPage {
    // #region Locators
    private String _accessLink = "//*[contains(@class,'MyTable')]//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/a[text()='%s']";
    private String _checkPriceLinkText = "check price";
    private String _bookTicketLinkText = "book ticket";

    private By _seatTypeHeader = By
            .xpath("//*[contains(@class, 'MyTable ')]//tr/th[contains(text(), 'Seat type')]/following-sibling::td");
    private By _seatPriceRow = By
            .xpath("//*[contains(@class, 'MyTable ')]//tr/th[contains(text(), 'Price')]/following-sibling::td");
    // #endregion

    // #region Methods
    public TimetablePage accessCheckPrice(Station departFrom, Station arriveAt) {
        Utilities.click(Utilities.getLocatorElement(_accessLink, departFrom.getName(), arriveAt.getName(),
                _checkPriceLinkText));
        return this;
    }

    public BookTicketPage navigateToBookTicketPage(Station departFrom, Station arriveAt) {
        Utilities.click(Utilities.getLocatorElement(_accessLink, departFrom.getName(), arriveAt.getName(),
                _bookTicketLinkText));
        return new BookTicketPage();
    }

    public Map<SeatType, Integer> getTicketPrices() {
        Map<SeatType, Integer> prices = new HashMap<>();
        List<String> seatTypes = Utilities.getTextList(_seatTypeHeader);
        List<String> seatPrices = Utilities.getTextList(_seatPriceRow);

        for (int i = 0; i < seatTypes.size(); i++) {
            prices.put(SeatType.getByShortName(seatTypes.get(i)), Integer.parseInt(seatPrices.get(i)));
        }

        return prices;
    }
    // #endregion
}
