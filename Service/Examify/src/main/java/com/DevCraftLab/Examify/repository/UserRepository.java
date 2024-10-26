package com.DevCraftLab.Examify.repository;

import com.DevCraftLab.Examify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String userName);
}
