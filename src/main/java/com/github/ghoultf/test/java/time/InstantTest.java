package com.github.ghoultf.test.java.time;

import java.text.ParseException;
import java.time.*;
import java.util.Date;

public class InstantTest {
    public static void main(String[] args) throws ParseException {
        Instant instant = Instant.now();
        Instant instant2 = Instant.parse("2019-08-20T14:30:00Z");

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate localDate = zonedDateTime.toLocalDate();
        LocalTime localTime = zonedDateTime.toLocalTime();
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        Date date = Date.from(instant);
        Instant instant3 = date.toInstant();
    }
}
