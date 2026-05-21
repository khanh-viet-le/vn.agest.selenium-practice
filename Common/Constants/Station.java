package Constants;

public enum Station {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế"),
    QUANG_NGAI("Quảng Ngãi");

    private final String name;

    Station(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Station getByName(String name) {
        for (Station station : Station.values()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }
}
