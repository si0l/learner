package com.sub.learner.javanewfeatures.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

public class Example1 {

    public static void main(String[] args) {

        // old way
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println(df.format(date));

        System.out.println(Calendar.getInstance().getTime());

        // new
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        LocalDate localDate = LocalDate.ofYearDay(2001, 3);
        System.out.println(localDate);
        localDate = LocalDate.of(2011, 2, 28);
        System.out.println(localDate);

        try {
            localDate = LocalDate.of(2011, 2, 29);
            System.out.println(localDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.get(ChronoField.DAY_OF_MONTH));

        // operations

        LocalDate localDate2 = localDate.plusDays(4); // local date is immutable
        System.out.println(localDate2);
        LocalDate localDate3 = localDate.minusYears(2);
        System.out.println(localDate3);
        System.out.println(localDate.plus(10, ChronoUnit.DAYS));
        System.out.println(localDate.plus(-110, ChronoUnit.DAYS));
        System.out.println(localDate.minus(110, ChronoUnit.DAYS));
        LocalDate localDate4 = localDate.withMonth(6);
        System.out.println(localDate4);
        System.out.println(localDate.with(ChronoField.YEAR, 2012));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println(LocalTime.of(1, 1, 3, 44));
        System.out.println(LocalTime.of(1, 1, 3, 44).getHour());
        System.out.println(LocalTime.of(1, 1, 3, 44).get(ChronoField.HOUR_OF_DAY));
        LocalTime lt = LocalTime.now();
        lt.plusHours(2);
        System.out.println(lt);
        lt.plus(2, ChronoUnit.HOURS); // ChronoUnit vs ChronoField
        System.out.println(lt);
        lt = lt.with(LocalTime.MIDNIGHT);
        System.out.println(lt);
        lt = LocalTime.from(LocalTime.MIDNIGHT);
        System.out.println(lt);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        ldt = LocalDateTime.of(localDate, lt);
        System.out.println(ldt);

        localDate = ldt.toLocalDate();
        lt = ldt.toLocalTime();
    }

}
