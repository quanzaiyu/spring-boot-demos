package com.example.jpa.model;

import com.example.jpa.enums.UserSexEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserSexEnum userSex;

    @Column(nullable = false, unique = true)
    private String nickName;

    public User(String userName, String passWord, UserSexEnum userSex, String nickName) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
        this.nickName = nickName;
    }
}
