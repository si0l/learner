package com.sub.learner.javanewfeatures.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Convert {

    public static void main(String[] args) {

        Date date = new Date();

        LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ldt);

        java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
        LocalDate ld = date2.toLocalDate();
        System.out.println(ld);

    }

}
