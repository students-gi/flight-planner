package io.codelex.flightplanner.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeFormatter {
    private static DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDateTimeFormatter() {
    }

    public static LocalDateTime stringToDateTime(String dateTime) throws DateTimeParseException {
        return LocalDateTime.parse(dateTime, dateTimePattern);
    }

    public static LocalDate stringToDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, datePattern);
    }

    public static String localDateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(dateTimePattern);
    }

    public static String localDateToString(LocalDate date) {
        return date.format(datePattern);
    }

}
