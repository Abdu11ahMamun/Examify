package com.DevCraftLab.Examify.domain;

import lombok.Data;

@Data
public class JwtRequest {
    String username;
    String password;
}
