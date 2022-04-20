package com.jmb.email.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeDateUtil {

    public static String convertTimestampToTimeAgo(Long unixTimeStamp) {
        PrettyTime prettyTime = new PrettyTime();
        return prettyTime.format(new Date(unixTimeStamp));
    }
}
