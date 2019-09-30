package com.example.jpa.multi.datasource.model;

import com.example.jpa.multi.datasource.enums.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserSexEnum userSex;

    @Column(nullable = true, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public User(String userName, String passWord, UserSexEnum userSex, String nickName) {
        this.userName = userName;
        this.passWord = passWord;
        this.userSex = userSex;
        this.nickName = nickName;
    }

    public User(String userName, String passWord, UserSexEnum userSex, String nickName, String email, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
        this.userSex = userSex;
    }
}
