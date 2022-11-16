package com.viktor.javalevel2.regularexpressions.homework.parse;

import com.viktor.javalevel2.regularexpressions.homework.dto.LogFileRow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFileParse {

    private static final int NUMBER = 0;
    private static final int DATA = 1;
    private static final int NAME = 2;
    private static final int PHONE = 3;
    private static final int COMPLAIN = 4;
    private static final String PHONE_NUMBER_REGEX = "(\\+375)? ?\\(?(\\d{2})\\)? ?(\\d{3}) ?(\\d{2}) ?(\\d{2})";
    private static final DateTimeFormatter DATA_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public List<LogFileRow> parse(Path path) throws IOException {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(this::getLogFileRow)
                    .collect(Collectors.toList());
        }
    }

    private LogFileRow getLogFileRow(String string) {
        String[] array = string.split(", ");
        String correctPhone = array[PHONE].replaceAll(PHONE_NUMBER_REGEX, "+375 ($2) $3-$4-$5");
        return new LogFileRow(
                Integer.parseInt(array[NUMBER]),
                LocalDateTime.parse(array[DATA], DATA_FORMATTER),
                array[NAME],
                correctPhone,
                array[COMPLAIN]);
    }
}
