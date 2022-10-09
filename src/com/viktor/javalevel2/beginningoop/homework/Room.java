package com.viktor.javalevel2.beginningoop.homework;

public class Room {
    private boolean isPassage;

    Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    void print() {
        if (isPassage) {
            System.out.println("Passage room");
        } else System.out.println("Not Passage room");
    }
}
