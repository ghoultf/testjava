package com.github.ghoultf.test.java.time;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 比较LocalDateTime之间相差的天数
 *
 * @author ghoul
 * @date 2023/06/13
 */
public class DaysBetweenLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime date1 = LocalDateTime.of(2020, 1, 29, 0, 0, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 2, 2, 0, 0, 0);

        System.out.println(date2.toLocalDate().toEpochDay() - date1.toLocalDate().toEpochDay() > 4);
        System.out.println(date1.plusDays(4).isAfter(date2));
        System.out.println(Duration.between(date1, date2).toDays() > 4);

    }
}
