package Constants;

public enum Station {
    SAI_GON("Sài Gòn", 1),
    PHAN_THIET("Phan Thiết", 2),
    NHA_TRANG("Nha Trang", 3),
    DA_NANG("Đà Nẵng", 4),
    HUE("Huế", 5),
    QUANG_NGAI("Quảng Ngãi", 6);

    private final String name;
    private final int value;

    Station(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public static Station getByName(String name) {
        for (Station station : Station.values()) {
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public int getValue() {
        return this.value;
    }
}
