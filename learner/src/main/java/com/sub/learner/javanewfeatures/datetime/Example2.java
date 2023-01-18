package com.sub.learner.javanewfeatures.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Example2 {

    public static void main(String[] args) {
        
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.now().plus(2, ChronoUnit.HOURS);

        Duration duration = Duration.between(ldt, ldt2); // ldt2 > ldt
        System.out.println(duration.toHours()); // duration = 2 hours (not -2 hours)

        System.out.println(Duration.ofHours(3));

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = lt1.plus(24, ChronoUnit.HOURS);
        Duration d2 = Duration.between(lt1, lt2);
        System.out.println(d2);

        try {
            LocalDate ld1 = LocalDate.now();
            LocalDate ld2 = ld1.plusDays(1);
            Duration d3 = Duration.between(ld1, ld2); // UnsupportedTemporalTypeException - can't find duration between dates (with no time)
            System.out.println(d3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
