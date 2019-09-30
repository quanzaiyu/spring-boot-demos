package com.example.jwt.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String Id;
    String username;
    String password;
}
