package com.viktor.javalevel2.beginningoop.homework;

public class Building {
    private int number;
    private Floor[] numberOfStoreys;

    Building(int number, Floor[] numberOfStoreys) {
        this.number = number;
        this.numberOfStoreys = numberOfStoreys;
    }

    void print() {
        System.out.println("Building number " + number + ", numbers of floor " + numberOfStoreys.length);
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    Floor[] getNumberOfStoreys() {
        return numberOfStoreys;
    }

    void setNumberOfStoreys(Floor[] numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }
}
