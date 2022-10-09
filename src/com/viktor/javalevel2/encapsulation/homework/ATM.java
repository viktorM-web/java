package com.viktor.javalevel2.encapsulation.homework;

/**
 * Создать класс, описывающий банкомат.
 * <p>
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 20, 50 и 100.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег,
 * а возвращает булево значение - успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * <p>
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 */
public class ATM {
    private static final int VALUE_OF_TEN = 10;
    private static final int VALUE_OF_TWENTY = 20;
    private static final int VALUE_OF_THIRTY = 30;
    private static final int VALUE_OF_FIFTY = 50;
    private static final int VALUE_OF_HUNDRED = 100;
    private int amountOfTwentyDollarBill;
    private int amountOfFiftyDollarBill;
    private int amountOfHundredDollarBill;
    private int amountOfMoneyInTheATM;
    private int counterWithdrawingTwenty;
    private int counterWithdrawingFifty;
    private int counterWithdrawingHundred;

    protected ATM(int amountOfTwentyDollarBill, int amountOfFiftyDollarBill, int amountOfHundredDollarBill) {
        this.amountOfTwentyDollarBill = amountOfTwentyDollarBill;
        this.amountOfFiftyDollarBill = amountOfFiftyDollarBill;
        this.amountOfHundredDollarBill = amountOfHundredDollarBill;
        countAmountOfMoneyInTheATM();
    }

    protected void addCashToTheATM(int amountOfTwentyDollarBill, int amountOfFiftyDollarBill,
                                   int amountOfHundredDollarBill) {
        this.amountOfTwentyDollarBill += amountOfTwentyDollarBill;
        this.amountOfFiftyDollarBill += amountOfFiftyDollarBill;
        this.amountOfHundredDollarBill += amountOfHundredDollarBill;
        countAmountOfMoneyInTheATM();
        System.out.format("%d - 20$ bills\n%d - 50$ bills\n%d - 100$ bills\nadded to an ATM\n",
                amountOfTwentyDollarBill, amountOfFiftyDollarBill, amountOfHundredDollarBill);
    }

    protected boolean withdrawCash(int amountOfMoney) {
        resentCounter();
        boolean flag = true;
        if (!isCorrectAmount(amountOfMoney)) {
            return false;
        } else if (amountOfMoney < VALUE_OF_HUNDRED) {
            flag = withdrawAmountLessHundred(amountOfMoney);
            if (!flag) {
                return false;
            }
        } else {
            flag = withdrawAmountMoreHundred(amountOfMoney);
            if (!flag) {
                return false;
            }
        }
        this.amountOfTwentyDollarBill -= counterWithdrawingTwenty;
        this.amountOfFiftyDollarBill -= counterWithdrawingFifty;
        this.amountOfHundredDollarBill -= counterWithdrawingHundred;
        countAmountOfMoneyInTheATM();
        System.out.printf("%d - 20$ bills\n%d - 50$ bills\n%d - 100$ bills\nwas withdrawn from the ATM\n",
                counterWithdrawingTwenty, counterWithdrawingFifty, counterWithdrawingHundred);
        return true;
    }

    private boolean withdrawAmountMoreHundred(int amountOfMoney) {
        boolean flag = true;
        int remainder = amountOfMoney % VALUE_OF_HUNDRED;
        int currentAmountOfMoney = amountOfMoney - remainder;
        flag = withdrawAmountLessHundred(remainder);
        if (!flag) {
            return false;
        }
        if (currentAmountOfMoney / VALUE_OF_HUNDRED <= amountOfHundredDollarBill) {
            counterWithdrawingHundred += currentAmountOfMoney / VALUE_OF_HUNDRED;
        } else {
            counterWithdrawingHundred = amountOfHundredDollarBill;
            currentAmountOfMoney -= counterWithdrawingHundred * VALUE_OF_HUNDRED;
            if (currentAmountOfMoney / VALUE_OF_FIFTY <= amountOfFiftyDollarBill - counterWithdrawingFifty) {
                counterWithdrawingFifty += currentAmountOfMoney / VALUE_OF_FIFTY;
            } else {
                int localAmountOfFiftyDollarBill = amountOfFiftyDollarBill - counterWithdrawingFifty;
                int localCounterOfFiftyDollarBill =
                        localAmountOfFiftyDollarBill % 2 == 0 ?
                                localAmountOfFiftyDollarBill : localAmountOfFiftyDollarBill - 1;
                currentAmountOfMoney -= localCounterOfFiftyDollarBill * VALUE_OF_FIFTY;
                counterWithdrawingFifty += localCounterOfFiftyDollarBill;
                if (currentAmountOfMoney / VALUE_OF_TWENTY <= amountOfTwentyDollarBill - counterWithdrawingTwenty) {
                    counterWithdrawingTwenty += currentAmountOfMoney / VALUE_OF_TWENTY;
                } else {
                    System.out.println("Try entering a different amount");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean withdrawAmountLessHundred(int amountOfMoney) {
        if (amountOfMoney % VALUE_OF_TWENTY == 0) {
            if (amountOfMoney / VALUE_OF_TWENTY <= amountOfTwentyDollarBill) {
                counterWithdrawingTwenty = amountOfMoney / VALUE_OF_TWENTY;
                return true;
            } else {
                System.out.println("Try entering a different amount");
                return false;
            }
        } else {
            if (amountOfFiftyDollarBill >= 1 &&
                    (amountOfMoney - VALUE_OF_FIFTY) / VALUE_OF_TWENTY <= amountOfTwentyDollarBill) {
                counterWithdrawingTwenty = (amountOfMoney - VALUE_OF_FIFTY) / VALUE_OF_TWENTY;
                counterWithdrawingFifty++;
                return true;
            } else {
                System.out.println("Try entering a different amount");
                return false;
            }
        }
    }

    private boolean isCorrectAmount(int amountOfMoney) {
        int remainder = amountOfMoney % VALUE_OF_HUNDRED;
        if (amountOfMoney > amountOfMoneyInTheATM) {
            System.out.println("Not enough money in the ATM");
            return false;
        } else if (remainder < VALUE_OF_TWENTY || remainder % VALUE_OF_TEN != 0 || remainder == VALUE_OF_THIRTY) {
            System.out.println("Not correct value, try again");
            return false;
        } else return true;
    }

    private void resentCounter() {
        counterWithdrawingTwenty = 0;
        counterWithdrawingFifty = 0;
        counterWithdrawingHundred = 0;
    }

    private void countAmountOfMoneyInTheATM() {
        amountOfMoneyInTheATM = this.amountOfTwentyDollarBill * VALUE_OF_TWENTY +
                this.amountOfFiftyDollarBill * VALUE_OF_FIFTY +
                this.amountOfHundredDollarBill * VALUE_OF_HUNDRED;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "amountOfTwentyDollarBill=" + amountOfTwentyDollarBill +
                ", amountOfFiftyDollarBill=" + amountOfFiftyDollarBill +
                ", amountOfHundredDollarBill=" + amountOfHundredDollarBill +
                ", amountOfMoneyInTheATM=" + amountOfMoneyInTheATM +
                '}';
    }
}
