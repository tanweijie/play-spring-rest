package org.weijie.playspringrest.service;

import org.springframework.stereotype.Service;
import org.weijie.playspringrest.model.Time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Set;
import java.util.TimeZone;

@Service
public class TimezoneService
{
    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a z";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public Time convertTime(String zone)
    {
        Calendar now = Calendar.getInstance();
        LocalDateTime today = LocalDateTime.now();

        TimeZone timeZone = now.getTimeZone();

        ZoneId fromTimeZone = timeZone.toZoneId();
        ZoneId targetTimezone = ZoneId.of(zone);

        ZonedDateTime currentTime = today.atZone(fromTimeZone);
        ZonedDateTime targetTime = currentTime.withZoneSameInstant(targetTimezone);

        return Time.builder().abroad(formatter.format(targetTime)).local(formatter.format(currentTime)).zone(zone).build();
    }

    public Set<String> listAllTimezone()
    {
        return ZoneId.getAvailableZoneIds();
    }
}
