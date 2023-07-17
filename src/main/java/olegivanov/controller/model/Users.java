package olegivanov.controller.model;

import lombok.Data;

import java.util.List;

public class Users {
    private static  String user;
    private static  String password;

    public Users() {
    }

    public static void setUser(String user) {
        Users.user = user;
    }

    public static void setPassword(String password) {
        Users.password = password;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public Users(String user, String password){
    this.user=user;
    this.password=password;
}
}
