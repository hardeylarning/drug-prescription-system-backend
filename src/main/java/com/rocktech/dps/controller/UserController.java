package com.rocktech.dps.controller;

import com.rocktech.dps.model.User;
import com.rocktech.dps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        return String.valueOf(userService.updateUser(id, user));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PatchMapping("{userId}/{roleId}")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUserRole(@PathVariable int userId, @PathVariable int roleId) {
        return userService.updateUserRole(userId, roleId);
    }

}
