package com.viktor.javalevel2.beginningoop.homework;

public class Runner {
    public static void main(String[] args) {
        Room passageRoom = new Room(true);
        Room notPassageRoom = new Room(false);
        Flat firstFlat = new Flat(1, new Room[]{passageRoom, passageRoom, notPassageRoom});
        Flat secondFlat = new Flat(2, new Room[]{passageRoom, passageRoom});
        Flat thirdFlat = new Flat(3, new Room[]{passageRoom, passageRoom});
        Flat fourthFlat = new Flat(4, new Room[]{passageRoom, passageRoom, notPassageRoom});
        Flat fifthFlat = new Flat(5, new Room[]{passageRoom, passageRoom});
        Flat sixthFlat = new Flat(6, new Room[]{passageRoom, passageRoom, notPassageRoom});
        Floor firstFloor = new Floor(1, new Flat[]{firstFlat});
        Floor secondFloor = new Floor(2, new Flat[]{secondFlat, thirdFlat, fourthFlat});
        Floor thirdFloor = new Floor(3, new Flat[]{fifthFlat, sixthFlat});
        Building building = new Building(160, new Floor[]{firstFloor, secondFloor, thirdFloor});
        printAllInformation(building);
    }

    private static void printAllInformation(Building building) {
        building.print();
        for (Floor floor : building.getNumberOfStoreys()) {
            System.out.print("  ");
            floor.print();
            for (Flat flat : floor.getPlanFloor()) {
                System.out.print("      ");
                flat.print();
                for (Room room : flat.getPlanFlat()) {
                    System.out.print("          ");
                    room.print();
                }
            }
        }
    }
}
