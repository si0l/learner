package com.sub.learner.javanewfeatures.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Example3 {

    public static void main(String[] args) {

        Instant timestamp = Instant.now();
        System.out.println(timestamp);
        System.out.println(timestamp.toEpochMilli());

        System.out.println(timestamp.plusMillis(3600));
        System.out.println(timestamp.plus(360, ChronoUnit.DAYS));

        System.out.println(Duration.between(timestamp, timestamp.plus(360, ChronoUnit.DAYS)).toHours());

        LocalDateTime ldt1 = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.println(ldt1);

        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/London")));

        ZonedDateTime zdt = ldt1.atZone(ZoneId.of("America/New_York"));
        System.out.println(zdt);

        OffsetDateTime odt = ldt1.atOffset(ZoneOffset.ofHours(3));
        System.out.println(odt);

    }

}
