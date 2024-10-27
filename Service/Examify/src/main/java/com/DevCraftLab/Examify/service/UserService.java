package com.DevCraftLab.Examify.service;

import com.DevCraftLab.Examify.entity.User;
import com.DevCraftLab.Examify.entity.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(String username);
}
