package com.example.test.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String nickname;
    private Integer sex;
    private Integer age; // 1 男 2 女
    private Date birthday;
    private String email;
    private String idcard;
    private Date create_time;
    private Date update_time;
}
