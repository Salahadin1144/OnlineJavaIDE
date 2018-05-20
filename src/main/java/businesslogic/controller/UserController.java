package businesslogic.controller;

import businesslogic.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> userList;

    public UserController() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("A", "a"));
        this.userList.add(new User("E", "e"));
        this.userList.add(new User("I", "i"));
        this.userList.add(new User("O", "o"));
        this.userList.add(new User("U", "u"));
    }

    public List<User> getUserList() {
        return userList;
    }
}
