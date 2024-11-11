package com.DevCraftLab.Examify.service.impl;

import com.DevCraftLab.Examify.entity.User;
import com.DevCraftLab.Examify.entity.UserRole;
import com.DevCraftLab.Examify.repository.RoleRepository;
import com.DevCraftLab.Examify.repository.UserRepository;
import com.DevCraftLab.Examify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User userAlreadyExist= this.userRepository.findByUsername(user.getUsername());
        if (userAlreadyExist !=null){
            throw new Exception("User already exist");
        }else {
            for (UserRole role: userRoles){
                roleRepository.save(role.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            User saveUser= this.userRepository.save(user);
            return saveUser;
        }
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
     this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user) throws Exception {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new Exception("User not found with id: " + user.getId()));
        if (user.getUsername() != null && !user.getUsername().trim().isEmpty()) {
            existingUser.setUsername(user.getUsername().trim());
        }
        if (user.getFirstName() != null && !user.getFirstName().trim().isEmpty()) {
            existingUser.setFirstName(user.getFirstName().trim());
        }
        if (user.getLastName() != null && !user.getLastName().trim().isEmpty()) {
            existingUser.setLastName(user.getLastName().trim());
        }
        if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
            existingUser.setEmail(user.getEmail().trim());
        }
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            existingUser.setPassword(user.getPassword().trim());
        }
        if (user.getPhone() != null && !user.getPhone().trim().isEmpty()) {
            existingUser.setPhone(user.getPhone().trim());
        }
        if (user.getImageUrl() != null && !user.getImageUrl().trim().isEmpty()) {
            existingUser.setImageUrl(user.getImageUrl().trim());
        }
        if (user.isActive() != existingUser.isActive()) {
            existingUser.setActive(user.isActive());
        }
        return userRepository.save(existingUser);
    }
}
/*
* project(abc)---> class(*.java) --> method (F2C)
*
*
*
*
* */