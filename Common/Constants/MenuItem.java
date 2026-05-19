package Constants;

public enum MenuItem {

    HOME("Home"),
    FAQ("FAQ"),
    CONTACT("Contact"),
    TIMETABLE("Timetable"),
    TICKET_PRICE("Ticket price"),
    BOOK_TICKET("Book ticket"),
    REGISTER("Register"),
    LOGIN("Login");

    private final String displayText;

    public String getText() {
        return this.displayText;
    }

    MenuItem(String displayText) {
        this.displayText = displayText;
    }
}
