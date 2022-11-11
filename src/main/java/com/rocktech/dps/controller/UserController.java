package com.rocktech.dps.controller;

import com.rocktech.dps.model.User;
import com.rocktech.dps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<User> allUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping("{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return String.valueOf(userService.updateUser(id, user));
    }

    @DeleteMapping
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    @PatchMapping("{userId}/{roleId}")
    public User updateUserRole(@PathVariable int userId, @PathVariable int roleId) {
        return userService.updateUserRole(userId, roleId);
    }

}
