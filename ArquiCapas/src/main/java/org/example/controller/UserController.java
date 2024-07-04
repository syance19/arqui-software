package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;

import java.util.regex.Pattern;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    public void saveUser(User user) {
        userService.saveUser(user);
    }

    public boolean deleteUser(String userId){ userService.deleteUser(userId);
        return true;
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(emailRegex, email);
    }
}
