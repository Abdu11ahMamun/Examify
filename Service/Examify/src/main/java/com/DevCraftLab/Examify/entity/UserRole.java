package com.DevCraftLab.Examify.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne
    private Role role;
}
