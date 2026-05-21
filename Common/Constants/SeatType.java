package Constants;

public enum SeatType {
    HARD_SEAT("Hard seat"),
    SOFT_SEAT("Soft seat"),
    SOFT_SEAT_WITH_AC("Soft seat with air conditioner"),
    HARD_BED("Hard bed"),
    SOFT_BED("Soft bed"),
    SOFT_BED_WITH_AC("Soft bed with air conditioner");

    private final String name;

    SeatType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static SeatType getByName(String name) {
        for (SeatType seatType : SeatType.values()) {
            if (seatType.getName().equals(name)) {
                return seatType;
            }
        }
        return null;
    }
}
