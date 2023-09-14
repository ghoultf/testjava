package com.github.ghoultf.test.java.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * 不考虑年月日，只比较时和分
 *
 * @date 2023/05/11
 */
public class CompareHourAndMin {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = simpleDateFormat.parse("2022-12-12 13:00:00");
        Date endDate = simpleDateFormat.parse("2021-11-11 14:00:00");

        ZonedDateTime zonedDateTime = startDate.toInstant().atZone(ZoneId.systemDefault());
        LocalTime startLT = zonedDateTime.toLocalTime();
        LocalTime endLT = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalTime startHAndMLT = LocalTime.of(startLT.getHour(), startLT.getMinute());
        LocalTime endHAndMLT = LocalTime.of(endLT.getHour(), endLT.getMinute());
        LocalTime nowLT = LocalTime.now();

        System.out.println(startLT);
        System.out.println(endLT);
        System.out.println(nowLT);
        System.out.println(nowLT.isAfter(startHAndMLT) && nowLT.isBefore(endHAndMLT));

    }
}
