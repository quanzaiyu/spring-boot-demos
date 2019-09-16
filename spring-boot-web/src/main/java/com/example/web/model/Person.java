package com.example.web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    String userName;
    String userAge;
    String userAddress;

    public Person(String userName, String userAge, String userAddress) {
        this.userName = userName;
        this.userAge = userAge;
        this.userAddress = userAddress;
    }
}
