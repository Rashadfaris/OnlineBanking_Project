package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.UserDetails;

public class UserListManager {
    private static List<UserDetails> userList = new ArrayList<>();

    public static void addUser(UserDetails user) {
        userList.add(user);
    }

    public static List<UserDetails> getUserList() {
        return userList;
    }
}