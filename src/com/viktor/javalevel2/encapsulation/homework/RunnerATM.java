package com.viktor.javalevel2.encapsulation.homework;

public class RunnerATM {
    public static void main(String[] args) {
        ATM atm = new ATM(2, 2, 1);
        System.out.println(atm.toString());
        atm.addCashToTheATM(8, 0, 0);
        System.out.println(atm.toString());
        atm.withdrawCash(20);
        atm.withdrawCash(270);
        System.out.println(atm.toString());
    }

}
