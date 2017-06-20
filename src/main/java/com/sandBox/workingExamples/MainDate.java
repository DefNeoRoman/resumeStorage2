package com.sandBox.workingExamples;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MainDate {
    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
    public static void main(String[] args) {
        String dateInString = "22-1-2015 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
        long start = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(System.currentTimeMillis()-start);
        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId);

        //LocalDateTime + ZoneId = ZonedDateTime
        ZonedDateTime asiaZonedDateTime = ldt.atZone(singaporeZoneId);
        System.out.println("Date (Singapore) : " + asiaZonedDateTime);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        System.out.println(localDateTime.getDayOfMonth());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh-M-dd yhmm:ss a");
        System.out.println(simpleDateFormat.format(date));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh-M-dd yhmm:ss a");

        System.out.println(dateTimeFormatter.format(localDateTime));
    }
}
