package com.viktor.javalevel2.beginningoop.homework;

public class Flat {
    private int numberFlat;
    private Room[] planFlat;

    Flat(int numberFlat, Room[] planFlat) {
        this.numberFlat = numberFlat;
        this.planFlat = planFlat;
    }

    void print() {
        System.out.println("Flat number " + numberFlat + ", numbers of rooms " + planFlat.length);
    }

    int getNumberFlat() {
        return numberFlat;
    }

    void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    Room[] getPlanFlat() {
        return planFlat;
    }

    void setPlanFlat(Room[] planFlat) {
        this.planFlat = planFlat;
    }
}
