package Railway;

import org.testng.annotations.Test;

public class BookTicketTest extends TestBase{
    @Test(description = "User can book 1 ticket at a time")
    public void TC12() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with a valid account", () -> {});
        step("3. Click on \"Book ticket\" tab", () -> {});
        step("4. Select the next 2 days from \"Depart date\"", () -> {});
        step("5. Select Depart from \"Nha Trang\" and Arrive at \"Huế\"", () -> {});
        step("6. Select \"Soft bed with air conditioner\" for \"Seat type\"", () -> {});
        step("7. Select \"1\" for \"Ticket amount\"", () -> {});
        step("8. Click on \"Book ticket\" button", () -> {
            vp("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)", () -> {});
        });
    }

    @Test(description = "User can book many tickets at a time")
    public void TC13() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with a valid account", () -> {});
        step("3. Click on \"Book ticket\" tab", () -> {});
        step("4. Select the next 25 days from \"Depart date\"", () -> {});
        step("5. Select \"Nha Trang\" for \"Depart from\" and \"Sài Gòn\" for \"Arrive at\"", () -> {});
        step("6. Select \"Soft seat with air conditioner\" for \"Seat type\"", () -> {});
        step("7. Select \"5\" for \"Ticket amount\"", () -> {});
        step("8. Click on \"Book ticket\" button", () -> {
            vp("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)", () -> {});
        });
    }

    @Test(description = "User can check price of ticket from Timetable")    
    public void TC14() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with a valid account", () -> {});
        step("3. Click on \"Timetable\" tab", () -> {});
        step("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"", () -> {
            vp("Price for each seat displays correctly: HS = 310000, SS = 335000, SSC = 360000, HB = 410000, SB = 460000, SBC = 510000", () -> {});
        });
    }

    @Test(description = "User can book ticket from Timetable")
    public void TC15() {
        step("Pre-condition: an actived account is existing", () -> {});
        step("1. Navigate to QA Railway Website", () -> {});
        step("2. Login with a valid account", () -> {});
        step("3. Click on \"Timetable\" tab", () -> {});
        step("4. Click on book ticket of route \"Quảng Ngãi\" to \"Huế\"", () -> {
            vp("Book ticket form is shown with the corrected \"depart from\" and \"Arrive at\"", () -> {});
        });
        step("5. Select Depart date = tomorrow", () -> {});
        step("6. Select Ticket amount = 5", () -> {});
        step("7. Click on \"Book ticket\" button", () -> {
            vp("Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)", () -> {});
        });
    }
}
