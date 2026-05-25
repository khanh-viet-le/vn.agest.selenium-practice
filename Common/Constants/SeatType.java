package Constants;

public enum SeatType {
    HARD_SEAT("Hard seat", "HS"),
    SOFT_SEAT("Soft seat", "SS"),
    SOFT_SEAT_WITH_AC("Soft seat with air conditioner", "SSC"),
    HARD_BED("Hard bed", "HB"),
    SOFT_BED("Soft bed", "SB"),
    SOFT_BED_WITH_AC("Soft bed with air conditioner", "SBC");

    private final String name;
    private final String shortName;

    SeatType(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public static SeatType getByName(String name) {
        for (SeatType seatType : SeatType.values()) {
            if (seatType.getName().equals(name)) {
                return seatType;
            }
        }
        return null;
    }

    public static SeatType getByShortName(String shortName) {
        for (SeatType seatType : SeatType.values()) {
            if (seatType.getShortName().equals(shortName)) {
                return seatType;
            }
        }
        return null;
    }
}
