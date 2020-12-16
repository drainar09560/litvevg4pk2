package com.example.litvevg4pk2;

import java.util.ArrayList;
import java.util.List;

public class UserStaicInfo {
    public static List<User> users = new ArrayList<>();
    public final static String POSITION = "position";

    private void AddUserInList() {
        users.add(new User("Иван", "Я устал", 19, 1));
        users.add(new User("Иван", "Я устал", 19, 0));
        users.add(new User("Иван", "Я устал", 19, 2));
        users.add(new User("Иван", "Я устал", 19, 1));
    }

    public UserStaicInfo(){
        if(users.size() == 0){
            AddUserInList();
        }
    }
}
