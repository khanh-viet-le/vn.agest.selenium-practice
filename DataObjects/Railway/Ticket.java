package Railway;

import java.time.LocalDate;
import Constants.SeatType;
import Constants.Station;

public class Ticket {
    // #region Properties
    private LocalDate departDate;
    private LocalDate bookDate;
    private Station departFrom;
    private Station arriveAt;
    private SeatType seatType;
    private int ticketAmount;
    // #endregion

    public Ticket() {
        this.departDate = LocalDate.now();
        this.bookDate = LocalDate.now();
        this.departFrom = Station.SAI_GON;
        this.arriveAt = Station.PHAN_THIET;
        this.seatType = SeatType.HARD_SEAT;
        this.ticketAmount = 1;
    }

    // #region Getters and Setters
    public LocalDate getDepartDate() {
        return departDate;
    }

    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    public Station getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(Station departFrom) {
        this.departFrom = departFrom;
    }

    public Station getArriveAt() {
        return this.arriveAt;
    }

    public void setArriveAt(Station arriveAt) {
        this.arriveAt = arriveAt;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }
    // #endregion

    public boolean isEqual(Ticket other) {
        return this.toString().equals(other.toString());
    }

    @Override
    public String toString() {
        return "Ticket [arriveAt=" + arriveAt + ", bookDate=" + bookDate + ", departDate="
                + departDate + ", departFrom=" + departFrom + ", seatType=" + seatType + ", ticketAmount="
                + ticketAmount + "]";
    }
}
