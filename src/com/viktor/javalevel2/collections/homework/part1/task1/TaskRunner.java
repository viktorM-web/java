package com.viktor.javalevel2.collections.homework.part1.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * <p>
 * Задача:
 * <p>
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * <p>
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей, а если это
 * количество совпадает, то по названию в алфавитном порядке.
 * <p>
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class TaskRunner {
    private static final int MIN_NUMBER_USERS = 1000;
    private static final Comparator<Chat> BY_NAME_NATURAL_ORDER = Comparator.comparing(Chat::name);
    private static final Comparator<Chat> BY_USERS_NUMBER_DESCENDING_ORDER = Comparator.comparing(Chat::numberOfUsers)
            .reversed();
    private static final Comparator<Chat> BY_USERS_NUMBER_AND_NAME = (Chat chat1, Chat chat2) -> BY_USERS_NUMBER_DESCENDING_ORDER
            .thenComparing(BY_NAME_NATURAL_ORDER).compare(chat1, chat2);

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>(Arrays.asList(new Chat("School", 60),
                new Chat("Work", 150), new Chat("BMW club", 1500),
                new Chat("Minsk", 2_000_000), new Chat("Amsterdam", 2_000_000),
                new Chat("Belarus", 8_000_000)));
        System.out.println(chats);
        chats.sort(BY_NAME_NATURAL_ORDER);
        System.out.println(chats);
        deleteChats(chats);
        System.out.println(chats);
        System.out.println();
        chats.sort(BY_USERS_NUMBER_AND_NAME);
        System.out.println(chats);
    }

    private static void deleteChats(List<Chat> chats) {
        chats.removeIf(chat -> chat.numberOfUsers() < MIN_NUMBER_USERS);
    }
}

record Chat(String name, int numberOfUsers) {
}
