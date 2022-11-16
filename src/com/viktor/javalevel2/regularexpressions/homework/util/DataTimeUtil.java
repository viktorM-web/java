package com.viktor.javalevel2.regularexpressions.homework.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DataTimeUtil {

    public static final DateTimeFormatter FORMATTER_FOR_REPORT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter FORMATTER_FOR_LOG = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private DataTimeUtil() {
    }

    public static String LocalDateTimeForReport() {
        return LocalDateTime.now().format(FORMATTER_FOR_REPORT);
    }

    public static String LocalDateTimeForLog() {
        return LocalDateTime.now().format(FORMATTER_FOR_LOG);
    }
}
