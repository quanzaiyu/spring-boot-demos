package com.example.mybatis.mapper;

import com.example.mybatis.entity.UserEntity;
import com.example.mybatis.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO user(user_name,pass_word,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE user SET user_name=#{userName},nick_name=#{nickName} WHERE id=#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    void delete(Long id);

}
