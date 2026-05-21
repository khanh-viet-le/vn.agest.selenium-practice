package Railway;

import java.time.LocalDate;

import Constants.SeatType;
import Constants.Station;

public class Ticket implements Comparable<Ticket> {
    // #region Properties
    private LocalDate departDate;
    private LocalDate bookDate;
    private Station departFrom;
    private Station arriveAt;
    private SeatType seatType;
    private int ticketAmount;
    private int amount;
    // #endregion

    public Ticket() {
        this.departDate = LocalDate.now();
        this.bookDate = LocalDate.now();
        this.departFrom = Station.SAI_GON;
        this.arriveAt = Station.PHAN_THIET;
        this.seatType = SeatType.HARD_SEAT;
        this.ticketAmount = 1;
        this.amount = 0;
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
        return arriveAt;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    // #endregion

    @Override
    public int compareTo(Ticket other) {
        if (other.amount != this.amount) {
            return -1;
        }

        if (other.arriveAt != this.arriveAt) {
            return -1;
        }

        if (other.departDate != this.departDate) {
            return -1;
        }

        if (other.departFrom != this.departFrom) {
            return -1;
        }

        if (other.seatType != this.seatType) {
            return -1;
        }

        if (other.ticketAmount != this.ticketAmount) {
            return -1;
        }

        return 0;
    }
}
