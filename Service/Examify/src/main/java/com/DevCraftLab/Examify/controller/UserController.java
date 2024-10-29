package com.DevCraftLab.Examify.controller;

import com.DevCraftLab.Examify.entity.Role;
import com.DevCraftLab.Examify.entity.User;
import com.DevCraftLab.Examify.entity.UserRole;
import com.DevCraftLab.Examify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;
    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles= new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        role.setRole("NORMAL");
        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user,roles);
    }
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")Long userId){
         this.userService.deleteUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User user) throws Exception {
        user.setId(userId);
        return this.userService.updateUser(user);
    }

}
