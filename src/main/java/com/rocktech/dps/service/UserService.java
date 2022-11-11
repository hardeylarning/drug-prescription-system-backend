package com.rocktech.dps.service;

import com.rocktech.dps.model.Role;
import com.rocktech.dps.model.User;
import com.rocktech.dps.repository.RoleRepository;
import com.rocktech.dps.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User insert(User user) {
        Role role = new Role();
        role.setRoleName("USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public int updateUser(int id, User user) {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()){
            userRepository.save(user);
            return id;
        }
        return user.getId();
    }

    public User updateUserRole(int userId, int roleId) {
        Role role = roleRepository.findById(roleId).get();
        User user = userRepository.findById(userId).get();

        Set<Role> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public String getEncodedPassword(String pass){
        return passwordEncoder.encode(pass);
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

}
