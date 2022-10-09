package com.viktor.javalevel1.cycles.homework;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */

public class Task3 {

    public static void main(String[] args) {
        double investPercent = 0.1;
        solution(investPercent);
    }

    private static void solution(double investPercent) {
        double profitPercent = 0.02;
        int salary = 600;
        int spending = 300;
        double brokerAccount = 0;
        double bankAccount = 0;
        int periodInMonth = 38;
        for (int i = 1; i <= periodInMonth; i++) {
            bankAccount += salary - salary * investPercent;
            bankAccount -= spending;
            brokerAccount = brokerAccount + brokerAccount * profitPercent + salary * investPercent;
            if (i % 6 == 0) {
                salary += 400;
            }
            System.out.println("In " + i + " month bankAccount " + bankAccount + "$" + " brokerAccount " + brokerAccount + "$");
        }
        System.out.println("RESULT:\n" + brokerAccount + "$ on Broker account\n" + bankAccount + "$ on Bank account");
    }
}
