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
    public void deleteUser(String username) {
        return;
    }
}
