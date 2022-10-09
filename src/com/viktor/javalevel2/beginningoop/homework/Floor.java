package com.viktor.javalevel2.beginningoop.homework;

public class Floor {
    private int numberFloor;
    private Flat[] planFloor;

    Floor(int numberFloor, Flat[] planFloor) {
        this.numberFloor = numberFloor;
        this.planFloor = planFloor;
    }

    void print() {
        System.out.println("Floor number " + numberFloor + ", numbers of flat " + planFloor.length);
    }

    int getNumberFloor() {
        return numberFloor;
    }

    void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    Flat[] getPlanFloor() {
        return planFloor;
    }

    void setPlanFloor(Flat[] planFloor) {
        this.planFloor = planFloor;
    }
}
