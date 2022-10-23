package com.viktor.javalevel2.collections.homework.part1.task1;

public class NumberOfUsersCompare implements java.util.Comparator<Chat> {
    private static final int REVERS = -1;
    private static final int ZERO = 0;

    @Override
    public int compare(Chat chat1, Chat chat2) {
        int result = Integer.compare(chat1.getNumberOfUsers(), chat2.getNumberOfUsers()) * REVERS;
        if (result == ZERO) {
            return chat1.getName().compareTo(chat2.getName());
        }
        return result;
    }
}
