package com.viktor.javalevel2.collections.homework.part1.task2;

import java.util.List;

public class Chat {
    private final String name;
    private final List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
