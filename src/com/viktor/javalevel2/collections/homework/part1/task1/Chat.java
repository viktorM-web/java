package com.viktor.javalevel2.collections.homework.part1.task1;

public class Chat implements Comparable<Chat> {
    private final String name;
    private final int numberOfUsers;

    public Chat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int compareTo(Chat chat) {
        return getName().compareTo(chat.getName());
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}
