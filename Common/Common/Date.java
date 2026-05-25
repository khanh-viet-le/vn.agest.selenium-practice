package Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static LocalDate getDateFromNow(int days) {
        return LocalDate.now().plusDays(days);
    }

    public static LocalDate getDateFromString(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate plusDaysOfDate(LocalDate date, int days) {
        return date.plusDays(days);
    }

    public static LocalDate getDateFromDate(String date, String format, int days) {
        return getDateFromString(date, format).plusDays(days);
    }
}
