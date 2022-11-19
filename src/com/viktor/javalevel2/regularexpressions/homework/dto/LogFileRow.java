package com.viktor.javalevel2.regularexpressions.homework.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogFileRow {
    private final int number;
    private final LocalDateTime dateTime;
    private final String nameAndSurname;
    private final String telephone;
    private final String complaint;

    public LogFileRow(int number, LocalDateTime dateTime, String nameAndSurname, String telephone, String complaint) {
        this.number = number;
        this.dateTime = dateTime;
        this.nameAndSurname = nameAndSurname;
        this.telephone = telephone;
        this.complaint = complaint;
    }

    public int getNumber() {
        return number;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogFileRow row = (LogFileRow) o;
        return number == row.number && Objects.equals(dateTime, row.dateTime) &&
                Objects.equals(nameAndSurname, row.nameAndSurname) && Objects.equals(telephone, row.telephone) &&
                Objects.equals(complaint, row.complaint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, dateTime, nameAndSurname, telephone, complaint);
    }
}
