package com.kevo.junk;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author kevo
 */
public class DaylightSavings {

    public static void main(String[] args) {
        // Illegal Millis 
        TimeZone tz;
        Calendar cal;

        tz = TimeZone.getDefault();
        tz = TimeZone.getTimeZone("EST");
        cal = GregorianCalendar.getInstance(tz);

        //cal.setTimeZone(tz);
        // Illegal time of 2:30 am
        cal.set(2016, 3, 13,
                // hour
                2, 30, 0);

        System.out.println("Date.parseLong "
                + new Date(Long.parseLong("1457852400000")));

        // System.out.println("TZ: " + tz.getDisplayName());
        // System.out.println("TZ: " + tz.inDaylightTime(cal.getTime()));
        System.out.println("Millis: " + cal.getTimeInMillis());
        System.out.println("Time 1: " + cal.getTime().toString());
        tz = TimeZone.getTimeZone("PST");
        cal.setTimeZone(tz);
        System.out.println("Time 2: " + cal.getTime().toString());
    }
}
