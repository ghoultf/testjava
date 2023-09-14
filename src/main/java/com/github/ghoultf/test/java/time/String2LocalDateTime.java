package com.github.ghoultf.test.java.time;

import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class String2LocalDateTime {
    public static void main(String[] args) {
        String dateStr = "2023-5-21 00:00:00";
        System.out.println(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.CHINESE)));

    }
}
