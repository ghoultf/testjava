package com.github.ghoultf.test.java.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatterVsSimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        testSimpleDateFormat();
        testDateTimeFormatter();
    }

    private static void testDateTimeFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime dateTime = LocalDateTime.now();
        String dateTimeStr = dateTime.format(formatter);

        LocalDateTime dateTime2 = LocalDateTime.parse("2019-08-20 14:30:00", formatter);

    }

    /**
     * 是Java 1.1引入的日期格式化类，线程不安全，使用时需要注意线程安全问题。
     */
    private static void testSimpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date();
        String dateStr = sdf.format(date);

        Date date2 = sdf.parse("2019-08-20 14:30:00");
    }
}
