package com.gjr.mapper;

import com.gjr.po.User;

/**
 * Created by geng
 * on 2017/1/26.
 */
public interface UserMapper {

    User findUserById(Integer id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}
