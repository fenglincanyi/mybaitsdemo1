package com.gjr.mapper;

import com.gjr.po.User;
import com.gjr.po.UserCustom;
import com.gjr.po.UserQueryVo;

import java.util.List;

/**
 * Created by geng
 * on 2017/1/26.
 */
public interface UserMapper {

    User findUserById(Integer id) throws Exception;

    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(Integer id) throws Exception;

    // 模糊查询，返回多个对象
    List<User> queryUserByName(String name) throws Exception;

    // 包装对象，进行输入映射  SELECT * FROM userinfo WHERE password='888888' AND username LIKE '%明%'
    List<UserCustom> queryUserList(UserQueryVo userQueryVo);

    // 包装对象，进行输入映射, 简单类型进行输出映射
    int countUserCondition(UserQueryVo userQueryVo);

    // 使用 resultMap 测试
    User queryUserByResultMap(Integer id);
}
