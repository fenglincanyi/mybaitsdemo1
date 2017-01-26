package com.gjr.mapper;

import com.gjr.po.User;

/**
 * Created by geng
 * on 2017/1/26.
 */
public interface UserMapper {

    User findUserById(Integer id);
}
