package com.viktor.javalevel2.collections.homework.part1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет список объектов типа
 * Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * <p>
 * Задача:
 * <p>
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * <p>
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class TaskRunner {
    private static final int MINIMUM_USER_AGE = 18;

    public static void main(String[] args) {
        List<User> usersFromBMWChat = Arrays.asList(new User(1001, 18, "Ivan"),
                new User(1032, 25, "Vasiliy"), new User(1025, 34, "Oleg"),
                new User(1006, 16, "Olga"), new User(1009, 50, "Maria"),
                new User(1012, 13, "Anastasia"), new User(1011, 23, "Viktor"));
        List<User> usersFromSchoolChat = Arrays.asList(new User(1002, 16, "Sergei"),
                new User(1033, 16, "Pavel"), new User(1026, 16, "Ksenia"),
                new User(1007, 36, "Irina"), new User(1009, 50, "Maria"),
                new User(1013, 28, "Vlad"), new User(1014, 31, "Petr"));
        List<User> usersFromMinskChat = Arrays.asList(new User(1002, 16, "Sergei"),
                new User(1033, 16, "Pavel"), new User(1026, 16, "Ksenia"),
                new User(1007, 36, "Irina"), new User(1009, 50, "Maria"),
                new User(1001, 18, "Ivan"), new User(1032, 25, "Vasiliy"),
                new User(1025, 34, "Oleg"), new User(1006, 16, "Olga"),
                new User(1019, 55, "Masha"), new User(1121, 63, "Maks"),
                new User(1012, 13, "Anastasia"), new User(1011, 23, "Viktor"),
                new User(1122, 57, "Margo"), new User(1124, 44, "Alex"));
        List<Chat> chats = Arrays.asList(new Chat("BMW", usersFromBMWChat),
                new Chat("School", usersFromSchoolChat), new Chat("Minsk", usersFromMinskChat));
        List<User> usersOlderEighteenth = getUsersOlderEighteenth(chats);
        System.out.println(usersOlderEighteenth);
        double averageAgeUsersOlderEighteenth = getAverageAgeUsers(usersOlderEighteenth);
        System.out.println(averageAgeUsersOlderEighteenth);
    }

    private static double getAverageAgeUsers(List<User> usersOlderEighteenth) {
        double sumAge = 0.0;
        for (Iterator<User> user = usersOlderEighteenth.iterator(); user.hasNext(); ) {
            sumAge += user.next().age();
        }
        return sumAge / usersOlderEighteenth.size();
    }

    private static List<User> getUsersOlderEighteenth(List<Chat> chats) {
        List<User> usersOlderEighteenth = new ArrayList<>();
        for (Chat chat : chats) {
            List<User> users = chat.users();
            for (User user : users) {
                if (user.age() > MINIMUM_USER_AGE && !usersOlderEighteenth.contains(user)) {
                    usersOlderEighteenth.add(user);
                }
            }
        }
        return usersOlderEighteenth;
    }
}

record User(int id, int age, String name) {
}

record Chat(String name, List<User> users) {
}