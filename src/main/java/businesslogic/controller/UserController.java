package businesslogic.controller;

import businesslogic.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("Saladin", "s"));
        this.userList.add(new User("Bertukan", "b"));
        this.userList.add(new User("Filmon", "f"));

    }

    public List<User> getUserList() {
        return userList;
    }
}
