package com.rocktech.dps.controller;

import com.rocktech.dps.model.Role;
import com.rocktech.dps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    @Autowired
    private UserService roleService;

    @PostMapping("/add-role")
    public Role createRole(@RequestBody Role role){
        return  roleService.addRole(role);
    }
}
