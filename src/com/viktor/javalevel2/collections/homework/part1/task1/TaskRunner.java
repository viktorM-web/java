package com.viktor.javalevel2.collections.homework.part1.task1;

import java.util.*;

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

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>(Arrays.asList(new Chat("School", 60),
                new Chat("Work", 150), new Chat("BMW club", 1500),
                new Chat("Minsk", 2_000_000), new Chat("Amsterdam", 2_000_000),
                new Chat("Belarus", 8_000_000)));
        System.out.println(chats);
        Collections.sort(chats);
        System.out.println(chats);
        removeChatsContainLessThan1000Users(chats);
        System.out.println(chats);
        chats.sort(new NumberOfUsersCompare());
        System.out.println(chats);
    }

    private static void removeChatsContainLessThan1000Users(List<Chat> chats) {
        for (Iterator<Chat> chatIterator = chats.iterator(); chatIterator.hasNext(); ) {
            if (chatIterator.next().getNumberOfUsers() < MIN_NUMBER_USERS) {
                chatIterator.remove();
            }
        }
    }
}
