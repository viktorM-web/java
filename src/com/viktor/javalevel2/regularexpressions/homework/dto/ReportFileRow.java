package com.viktor.javalevel2.regularexpressions.homework.dto;

public class ReportFileRow {
    private final String numberComplaint;
    private final String dateTime;
    private final String telephone;

    public ReportFileRow(int numberComplaint, String dateTime, String telephone) {
        this.numberComplaint = String.valueOf(numberComplaint);
        this.dateTime = dateTime;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return numberComplaint + ", " + dateTime + ", " + telephone;
    }
}
